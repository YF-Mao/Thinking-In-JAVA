package bingguo.api;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/9/23
 **/
public abstract class Constants {
    public static final String FORMAT_JSON = "json";
    public static final String FORMAT_JSON2 = "json2";

    /**
     * 默认时间格式
     **/
    public static final String DEFAULT_DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    /**
     * 默认时区
     */
    public static final String DEFAULT_DATE_TIMEZONE = "GMT+8";

    /**
     * UTF-8字符集
     */
    public static final String CHARSET_UTF8 = "UTF-8";

    /**
     * 默认媒体类型
     */
    public static final String MIME_TYPE_DEFAULT = "application/octet-stream";

    /**
     * 默认流式读取缓存区大小
     */
    public static final int READ_BUFFER_SIZE = 1024 * 4;
    public static final String DNS_HOST = "DNS_HOST";

    /**
     * HTTP请求共享参数
     */
    public static final String CONTENT_TYPE_UTF8 = "text/xml;charset=utf-8";
    public static final String CONTENT_TYPE_JOSN_UTF8 = "application/json;charset=utf-8";
    public static final String METHOD_POST = "POST";
    public static final String METHOD_GET = "GET";
    public static final String HTTP_APP_JSON = "application/json";
    public static final String HTTP_FORM_DATA = "application/x-www-form-urlencoded";
    public static final String HTTP_FILE_UPLOAD = "multipart/form-data";

    public static final String HTTP_FILE_FORM_DATA = "Content-Disposition:form-data";

    /**
     * 响应编码
     */
    public static final String CONTENT_ENCODING_GZIP = "gzip";
}
