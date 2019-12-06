package util;

import bingguo.api.BaseFile;
import bingguo.api.Constants;
import bingguo.api.internal.util.HttpResponseData;
import com.alibaba.fastjson.JSONObject;
import org.omg.CORBA.PUBLIC_MEMBER;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.*;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.zip.GZIPInputStream;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/9/25
 **/
public class HttpUrlUtils {
    private static final String DEFAULT_CHARSET = Constants.CHARSET_UTF8;
    // 默认连接超时时间为15秒
    protected static int connectTimeout = 15000;
    // 默认响应超时时间为30秒
    protected static int readTimeout = 30000;

    public static String buildQuery(Map<String, String> params, String charset) throws IOException {
        if (params == null || params.isEmpty()) {
            return null;
        }

        StringBuilder query = new StringBuilder();
        boolean hasParam = false;

        for (Map.Entry<String, String> entry : params.entrySet()) {
            String name = entry.getKey();
            String value = entry.getValue();
            if (StringUtil.areNotEmpty(name, value)) {
                if (hasParam) {
                    query.append("&");
                } else {
                    hasParam = true;
                }
                query.append(name).append("=").append(URLEncoder.encode(name, charset));
            }

        }
        return query.toString();
    }

    public static String buildRequestUrl(String url, String... queries) {
        if (queries == null || queries.length == 0) {
            return url;
        }
        StringBuilder newUrl = new StringBuilder(url);
        boolean hasQuery = url.contains("?");
        boolean hasPrepend = url.endsWith("?") || url.endsWith("&");

        for (String query : queries) {
            if (!StringUtil.isEmpty(query)) {
                if (!hasPrepend) {
                    if (hasQuery) {
                        newUrl.append("&");
                    } else {
                        newUrl.append("?");
                        hasQuery = true;
                    }
                }
                newUrl.append(query);
                hasPrepend = false;
            }
        }
        return newUrl.toString();
    }

    public static URL buildGetUrl(String url, String query) throws IOException {
        if (StringUtil.isEmpty(query)) {
            return new URL(url);
        }
        return new URL(buildRequestUrl(url, query));
    }

    /**
     * 执行默认的HTTP请求
     *
     * @param url     请求地址
     * @param cType   请求类型，如果headMap中有请求类型则覆盖
     * @param apiBody 请求参数的JSON串
     * @param headMap 请求头部参数
     * @return HttpResponseData
     * @throws IOException
     * @author YF.Mao
     */
    public static HttpResponseData doPost(String url, String cType, String apiBody, Map<String, String> headMap) throws IOException {
        return _doPost(url, cType, apiBody.getBytes(Constants.CHARSET_UTF8), connectTimeout, readTimeout, headMap, null);
    }

    /**
     * 执行详细的HTTP请求
     *
     * @param url            请求地址
     * @param cType          请求类型，如果headMap中有请求类型则覆盖
     * @param content        请求参数的字节数组
     * @param headMap        请求头部参数
     * @param connectTimeout 连接超时时间
     * @param readTimeout    响应超时时间
     * @return HttpResponseData
     * @throws IOException
     * @author YF.Mao
     */
    public static HttpResponseData doPost(String url, String cType, byte[] content, int connectTimeout, int readTimeout, Map<String, String> headMap, Proxy proxy) throws IOException {
        return _doPost(url, cType, content, connectTimeout, readTimeout, headMap, proxy);
    }

    /**
     * 执行表单形式的HTTP请求
     */
    public static HttpResponseData doPost(String url, Map<String, String> params, String charset, int connectTimeout, int readTimeout, Map<String, String> headMap, Proxy proxy) throws IOException {
        String cType = Constants.HTTP_FORM_DATA + ";charset=" + charset;
        String query = buildQuery(params, charset);
        byte[] content = {};
        if (query != null) {
            content = query.getBytes();
        }
        return _doPost(url, cType, content, connectTimeout, readTimeout, headMap, proxy);
    }

    public static HttpResponseData doPost(String url, Map<String, String> params, Map<String, BaseFile> fileParams, String charset,
                                          int connectTimeout, int readTimeout, Map<String, String> headMap) throws IOException {
        if (fileParams == null || fileParams.isEmpty()) {
            return doPost(url, params, charset, connectTimeout, readTimeout, headMap, null);
        } else {
            return _doPostWithFile(url, params, fileParams, charset, connectTimeout, readTimeout, headMap);
        }
    }

    public static HttpResponseData doPost(String url, Map<String, String> params, String charset, int connectTimeout, int readTimeout, Map<String, String> headMap) throws IOException {
        String cType = Constants.HTTP_APP_JSON + ";charset=" + charset;
        byte[] content = JSONObject.toJSONString(params).getBytes(charset);
        return _doPost(url, cType, content, connectTimeout, readTimeout, headMap, null);
    }

    /**
     * 执行HTTP GET请求
     *
     * @param url            请求地址
     * @param params         请求参数
     * @param connectTimeout 连接超时时间
     * @param readTimeout    响应超时时间
     * @return HttpResponseData
     * @throws IOException
     * @author YF.Mao
     */
    public static HttpResponseData doGet(String url, Map<String, String> params, String charset, int connectTimeout, int readTimeout) throws IOException {
        HttpURLConnection connection = null;
        String rsp = null;
        HttpResponseData data = new HttpResponseData();
        try {
            String cType = Constants.HTTP_FORM_DATA + ";charset=" + charset;
            String query = buildQuery(params, charset);
            connection = getConnection(buildGetUrl(url, query), Constants.METHOD_GET, cType, null, null);
            connection.setConnectTimeout(connectTimeout);
            connection.setReadTimeout(readTimeout);
            rsp = getResponseAsString(connection);
            data.setBody(rsp);
            data.setHeaders(connection.getHeaderFields());
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
        return data;
    }

    private static HttpResponseData _doPost(String url, String cType, byte[] content, int connectTimeout, int readTimeout, Map<String, String> headMap, Proxy proxy) throws IOException {
        HttpURLConnection conn = null;
        OutputStream outputStream = null;
        String rsp = null;
        HttpResponseData data = new HttpResponseData();
        try {
            conn = getConnection(new URL(url), Constants.METHOD_POST, cType, headMap, proxy);
            conn.setConnectTimeout(connectTimeout);
            conn.setReadTimeout(readTimeout);
            outputStream = conn.getOutputStream();
            outputStream.write(content);
            rsp = getResponseAsString(conn);
            data.setBody(rsp);
            Map<String, List<String>> headers = conn.getHeaderFields();
            data.setHeaders(headers);
        } finally {
            if (outputStream != null) {
                outputStream.close();
            }
            if (conn != null) {
                conn.disconnect();
            }
        }
        return data;
    }

    private static HttpResponseData _doPostWithFile(String url, Map<String, String> params, Map<String, BaseFile> fileParams,
                                                    String charset, int connectTimeout, int readTimeout, Map<String, String> headMap) throws IOException {
        HttpURLConnection conn = null;
        OutputStream outputStream = null;
        String rsp = null;
        HttpResponseData data = new HttpResponseData();
        String boundary = String.valueOf(System.nanoTime());
        try {
            String cType = Constants.HTTP_FILE_UPLOAD + ";charset=" + charset + ";boundary=" + boundary;
            conn = getConnection(new URL(url), Constants.METHOD_POST, cType, headMap, null);
            conn.setConnectTimeout(connectTimeout);
            conn.setReadTimeout(readTimeout);
            outputStream = conn.getOutputStream();
            byte[] entryBoundaryBytes = ("\r\n--" + boundary + "\r\n").getBytes();

            // 带文件的HTTP请求中添加文本请求参数
            for (Entry<String, String> entry : params.entrySet()) {
                byte[] textBytes = getTextEntry(entry.getKey(), entry.getValue(), charset);
                outputStream.write(entryBoundaryBytes);
                outputStream.write(textBytes);
            }

            // 带文件的HTTP请求中添加文件请求参数
            for (Entry<String, BaseFile> entry : fileParams.entrySet()) {
                BaseFile baseFile = entry.getValue();
                if (!baseFile.isValid()) {
                    throw new IOException("BaseFile is invalid");
                }
                byte[] fileBytes = getFileEntry(entry.getKey(), baseFile.getFileName(), baseFile.getMimeType(), charset);
                outputStream.write(entryBoundaryBytes);
                outputStream.write(fileBytes);
                baseFile.write(outputStream);
            }

            // 请求结束
            byte[] endBoundaryBytes = ("\r\n--" + boundary + "--\r\n").getBytes(charset);
            outputStream.write(endBoundaryBytes);
            rsp = getResponseAsString(conn);
            data.setBody(rsp);
            data.setHeaders(conn.getHeaderFields());
        } finally {
            if (outputStream != null) {
                outputStream.close();
            }
            if (conn != null) {
                conn.disconnect();
            }
        }
        return data;
    }

    private static HttpURLConnection getConnection(URL url, String method, String cType, Map<String, String> headMap, Proxy proxy) throws IOException {
        HttpURLConnection connection = null;
        if (proxy == null) {
            connection = (HttpURLConnection) url.openConnection();
        } else {
            connection = (HttpURLConnection) url.openConnection(proxy);
        }

        if (connection instanceof HttpsURLConnection) {
            HttpsURLConnection httpsConnection = (HttpsURLConnection) connection;
        }

        connection.setRequestMethod(method);
        connection.setDoInput(true);
        connection.setDoOutput(true);
        if (headMap != null && headMap.get(Constants.DNS_HOST) != null) {
            connection.setRequestProperty("Host", headMap.get(Constants.DNS_HOST));
        } else {
            connection.setRequestProperty("Host", url.getHost());
        }

        connection.setRequestProperty("Content-Type", cType);
        if (headMap != null) {
            for (Entry<String, String> entry : headMap.entrySet()) {
                if (!Constants.DNS_HOST.equals(entry.getKey())) {
                    connection.setRequestProperty(entry.getKey(), entry.getValue());
                }
            }
        }


        return connection;
    }

    /**
     * 解析http请求，返回成String
     */
    protected static String getResponseAsString(HttpURLConnection conn) throws IOException {
        String charset = getResponseCharset(conn.getContentType());
        if (conn.getResponseCode() < HttpURLConnection.HTTP_BAD_REQUEST) {
            String contentEncoding = conn.getContentEncoding();
            if (Constants.CONTENT_ENCODING_GZIP.equalsIgnoreCase(contentEncoding)) {
                return getStreamAsString(new GZIPInputStream(conn.getInputStream()), charset);
            } else {
                return getStreamAsString(conn.getInputStream(), charset);
            }
        } else {
            if (conn.getResponseCode() == HttpURLConnection.HTTP_BAD_REQUEST) {
                InputStream error = conn.getInputStream();
                if (error != null) {
                    return getStreamAsString(error, charset);
                }
            }
            throw new IOException(conn.getResponseCode() + " " + conn.getResponseMessage());
        }
    }

    public static String getStreamAsString(InputStream stream, String charset) throws IOException {
        try {
            Reader reader = new InputStreamReader(stream, charset);
            StringBuilder response = new StringBuilder();

            final char[] buf = new char[1024];
            int i = 0;
            while ((i = reader.read(buf)) != -1) {
                response.append(buf, 0, i);
            }
            return response.toString();
        } finally {
            if (stream != null) {
                stream.close();
            }
        }
    }

    private static byte[] getTextEntry(String fieldName, String fieldValue, String charset) throws IOException {
        StringBuilder entry = new StringBuilder();
        entry.append(Constants.HTTP_FILE_FORM_DATA).append(";name=\"");
        entry.append(fieldName);
        entry.append("\"\r\nContent-Type:text/plain\r\n\r\n");
        entry.append(fieldValue);
        return entry.toString().getBytes(charset);
    }

    private static byte[] getFileEntry(String fieldName, String fileName, String mimeType, String charset) throws IOException {
        StringBuilder entry = new StringBuilder();
        entry.append(Constants.HTTP_FILE_FORM_DATA).append(";name=\"");
        entry.append(fieldName);
        entry.append("\"filename=\"");
        entry.append(fileName);
        entry.append("\"\r\nContent-Type:");
        entry.append(mimeType);
        entry.append("\r\n\r\n");
        return entry.toString().getBytes(charset);
    }

    /**
     * 获取字符编码
     */
    public static String getResponseCharset(String cType) {
        String charset = DEFAULT_CHARSET;

        if (!StringUtil.isEmpty(cType)) {
            String[] params = cType.split(";");
            for (String param : params) {
                if (param.startsWith("charset")) {
                    String[] pair = param.split("=", 2);
                    if (pair.length == 2) {
                        if (!StringUtil.isEmpty(pair[1])) {
                            charset = pair[1].trim();
                        }
                    }
                    break;
                }
            }
        }
        return charset;
    }
}
