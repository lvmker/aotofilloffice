package com.bgi.ms.engine.base.utils;


import java.io.UnsupportedEncodingException;
import java.net.SocketTimeoutException;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.net.ssl.SSLContext;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.ConnectionPoolTimeoutException;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.TrustStrategy;
import org.apache.http.util.EntityUtils;

import com.bgi.ms.engine.base.bean.MongoRequestParamer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * 工具类:HttpClient
 * 
 * @author Cocoaer
 * 
 */
public final class HttpClientUtil {


	/**
	 * 字符编码:UTF-8
	 */
	private static final String CHARSET = "UTF-8";

	/**
	 * 超时时间:15000(单位:毫秒)
	 */
	private static final int TIMEOUT = 60000;
	
	/**
	 * 错误消息:无法访问
	 */
	private static final String ERROR_MESSAGE_UNKNOWN_HOST = "无法访问";
	
	/**
	 * 默认请求配置信息
	 */
	private static final RequestConfig REQUEST_CONFIG = RequestConfig.custom()
			.setCookieSpec(CookieSpecs.STANDARD_STRICT)
			.setConnectionRequestTimeout(TIMEOUT)
			.setConnectTimeout(TIMEOUT)
			.setSocketTimeout(TIMEOUT)
			.build();
	
	/**
	 * HTTP GET
	 * 
	 * @param url
	 * @return
	 * @throws Exception
	 */
	public static String get(String url) throws Exception {

		return get(url, null, CHARSET, false);// 使用默认字符编码
	}
	
	/**
	 * HTTP GET
	 * 
	 * @param url
	 * @param charset
	 * @return
	 * @throws Exception
	 */
	public static String get(String url, String charset) throws Exception {

		return get(url, null, charset, false);// 使用自定义字符编码
	}

	/**
	 * HTTP GET
	 * 
	 * @param url
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public static String get(String url, Map<String, Object> paramMap) throws Exception {

		return get(url, paramMap, CHARSET, false);// 使用默认字符编码
	}
	
	/**
	 * HTTPS GET
	 * @param url
	 * @return
	 * @throws Exception
	 */
	public static String getSSL(String url) throws Exception {

		return get(url, null, CHARSET, true);// 使用默认字符编码
	}
	
	/**
	 * HTTPS GET
	 * @param url
	 * @param charset
	 * @return
	 * @throws Exception
	 */
	public static String getSSL(String url, String charset) throws Exception {

		return get(url, null, charset, true);// 使用自定义字符编码
	}
	
	/**
	 * HTTPS GET
	 * @param url
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public static String getSSL(String url, Map<String, Object> paramMap) throws Exception {

		return get(url, paramMap, CHARSET, true);// 使用默认字符编码
	}
	
	/**
	 * HTTP GET
	 * 
	 * @param url
	 * @param paramMap
	 * @param timeout
	 * @return
	 * @throws Exception
	 */
	public static String get(String url, Map<String, Object> paramMap, int timeout) throws Exception {

		return get(url, paramMap, CHARSET, timeout);// 使用默认字符编码，自定义超时时间
	}
	
	/**
	 * HTTP GET
	 * 
	 * @param url
	 * @param paramMap
	 * @param header
	 * @return
	 * @throws Exception
	 */
	public static String get(String url, Map<String, Object> paramMap, Map<String, Object> header) throws Exception {
		
		return get(url, paramMap, CHARSET, header);// 使用默认字符编码，自定义请求头
	}
	
	/**
	 * HTTP/HTTPS GET
	 * 
	 * @param url
	 * @param paramMap
	 * @param charset
	 * @return
	 * @throws Exception
	 */
	public static String get(String url, Map<String, Object> paramMap, String charset, boolean enableSSL) throws Exception {

		CloseableHttpClient client = (enableSSL) ? createSSLClient() : HttpClients.createDefault();
		
		CloseableHttpResponse response = null;
		try {

			if (ValidatorUtil.isNotEmpty(paramMap)) {

				url = url.concat((url.indexOf("?") == -1) ? "?" : "&").concat(
						EntityUtils.toString(new UrlEncodedFormEntity(convertParam(paramMap), charset)));
			}
			HttpGet get = new HttpGet(url);
			get.setConfig(REQUEST_CONFIG);
			response = client.execute(get);
			return getResponseResult(response, charset);
		} catch (ConnectionPoolTimeoutException e) {
			throw new ConnectionPoolTimeoutException(createErrorMessage(url, createErrorMessageTimeout(TIMEOUT)));
		} catch (ConnectTimeoutException e) {
			throw new ConnectTimeoutException(createErrorMessage(url, createErrorMessageTimeout(TIMEOUT)));
		} catch (SocketTimeoutException e) {
			throw new SocketTimeoutException(createErrorMessage(url, createErrorMessageTimeout(TIMEOUT)));
		} catch (UnknownHostException e) {
			throw new UnknownHostException(createErrorMessage(url, ERROR_MESSAGE_UNKNOWN_HOST));
		} catch (Exception e) {
			throw e;
		} finally {
			try {
				if (null != response) {
					response.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			client.close();
		}
	}
	
	/**
	 * HTTP GET
	 * 
	 * @param url
	 * @param paramMap
	 * @param charset
	 * @param timeout
	 * @return
	 * @throws Exception
	 */
	public static String get(String url, Map<String, Object> paramMap, String charset, int timeout) throws Exception {

		CloseableHttpClient client = HttpClients.createDefault();
		CloseableHttpResponse response = null;
		try {

			if (ValidatorUtil.isNotEmpty(paramMap)) {

				url = url.concat((url.indexOf("?") == -1) ? "?" : "&").concat(
						EntityUtils.toString(new UrlEncodedFormEntity(convertParam(paramMap), charset)));
			}
			HttpGet get = new HttpGet(url);
			get.setConfig(createConfig(timeout));
			response = client.execute(get);
			return getResponseResult(response, charset);
		} catch (ConnectionPoolTimeoutException e) {
			throw new ConnectionPoolTimeoutException(createErrorMessage(url, createErrorMessageTimeout(timeout)));
		} catch (ConnectTimeoutException e) {
			throw new ConnectTimeoutException(createErrorMessage(url, createErrorMessageTimeout(timeout)));
		} catch (SocketTimeoutException e) {
			throw new SocketTimeoutException(createErrorMessage(url, createErrorMessageTimeout(timeout)));
		} catch (UnknownHostException e) {
			throw new UnknownHostException(createErrorMessage(url, ERROR_MESSAGE_UNKNOWN_HOST));
		} catch (Exception e) {
			throw e;
		} finally {
			try {
				if (null != response) {
					
					response.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			client.close();
		}
	}
	
	/**
	 * HTTP GET
	 * 
	 * @param url
	 * @param paramMap
	 * @param charset
	 * @param header
	 * @return
	 * @throws Exception
	 */
	public static String get(String url, Map<String, Object> paramMap, String charset, Map<String, Object> header) throws Exception {
		
		CloseableHttpClient client = HttpClients.createDefault();
		CloseableHttpResponse response = null;
		try {
			
			if (ValidatorUtil.isNotEmpty(paramMap)) {
				
				url = url.concat((url.indexOf("?") == -1) ? "?" : "&").concat(
						EntityUtils.toString(new UrlEncodedFormEntity(convertParam(paramMap), charset)));
			}
			HttpGet get = new HttpGet(url);
			if (null != header) {
				
				for (Entry<String, Object> entry: header.entrySet()) {
					
					get.addHeader(entry.getKey().toString(), entry.getValue().toString());
				}
			}
			get.setConfig(REQUEST_CONFIG);
			response = client.execute(get);
			return getResponseResult(response, charset);
		} catch (ConnectionPoolTimeoutException e) {
			
			throw new ConnectionPoolTimeoutException(createErrorMessage(url, createErrorMessageTimeout(TIMEOUT)));
		} catch (ConnectTimeoutException e) {
			
			throw new ConnectTimeoutException(createErrorMessage(url, createErrorMessageTimeout(TIMEOUT)));
		} catch (SocketTimeoutException e) {
			
			throw new SocketTimeoutException(createErrorMessage(url, createErrorMessageTimeout(TIMEOUT)));
		} catch (UnknownHostException e) {
			
			throw new UnknownHostException(createErrorMessage(url, ERROR_MESSAGE_UNKNOWN_HOST));
		} catch (Exception e) {
			throw e;
		} finally {
			
			try {
				
				if (null != response) {
					
					response.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			client.close();
		}
	}
	
	/**
	 * HTTP GET(需要身份认证)
	 * 
	 * @param url
	 * @param username
	 * @param password
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public static String getAuth(String url, String username, String password, Map<String, Object> paramMap) throws Exception {
		
		return getAuth(url, username, password, paramMap, CHARSET);
	}
	
	/**
	 * HTTP GET(需要身份认证)
	 * 
	 * @param url
	 * @param username
	 * @param password
	 * @param paramMap
	 * @param charset
	 * @return
	 * @throws Exception
	 */
	public static String getAuth(String url, String username, String password, Map<String, Object> paramMap, String charset) throws Exception {
		
		CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
		credentialsProvider.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials(username, password));
		CloseableHttpClient client = HttpClients.custom().setDefaultCredentialsProvider(credentialsProvider).build();
		CloseableHttpResponse response = null;
		try {

			if (ValidatorUtil.isNotEmpty(paramMap)) {

				url = url.concat((url.indexOf("?") == -1) ? "?" : "&").concat(
						EntityUtils.toString(new UrlEncodedFormEntity(convertParam(paramMap), charset)));
			}
			HttpGet get = new HttpGet(url);
			get.setConfig(REQUEST_CONFIG);
			response = client.execute(get);
			return getResponseResult(response, charset);
		} catch (ConnectionPoolTimeoutException e) {
			throw new ConnectionPoolTimeoutException(createErrorMessage(url, createErrorMessageTimeout(TIMEOUT)));
		} catch (ConnectTimeoutException e) {
			throw new ConnectTimeoutException(createErrorMessage(url, createErrorMessageTimeout(TIMEOUT)));
		} catch (SocketTimeoutException e) {
			throw new SocketTimeoutException(createErrorMessage(url, createErrorMessageTimeout(TIMEOUT)));
		} catch (UnknownHostException e) {
			throw new UnknownHostException(createErrorMessage(url, ERROR_MESSAGE_UNKNOWN_HOST));
		} catch (Exception e) {
			throw e;
		} finally {
			try {
				if (null != response) {
					response.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			client.close();
		}
	}

	/**
	 * HTTP POST
	 * 
	 * @param url
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public static String post(String url, Map<String, Object> paramMap) throws Exception {

		return post(url, paramMap, CHARSET, false);// 使用默认字符编码，不启用SSL
	}
	
	/**
	 * HTTP POST
	 * 
	 * @param url
	 * @param paramMap
	 * @param timeout
	 * @return
	 * @throws Exception
	 */
	public static String post(String url, Map<String, Object> paramMap, int timeout) throws Exception {
		
		return post(url, paramMap, CHARSET, false, timeout);// 使用默认字符编码，不启用SSL，自定义超时时间
	}
	
	/**
	 * HTTP POST
	 * 
	 * @param url
	 * @param paramMap
	 * @param charset
	 * @return
	 * @throws Exception
	 */
	public static String post(String url, Map<String, Object> paramMap, String charset) throws Exception {

		return post(url, paramMap, charset, false);// 使用自定义字符编码，不启用SSL
	}
	
	/**
	 * HTTP POST
	 * 
	 * @param url
	 * @param paramMap
	 * @param header
	 * @return
	 * @throws Exception
	 */
	public static String post(String url, Map<String, Object> paramMap, Map<String, Object> header) throws Exception {

		return post(url, paramMap, CHARSET, false, header);// 使用自定义字符编码，不启用SSL
	}

	/**
	 * HTTPS POST
	 * 
	 * @param url
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public static String postSSL(String url, Map<String, Object> paramMap) throws Exception {

		return post(url, paramMap, CHARSET, true);// 使用默认字符编码，启用SSL
	}
	
	/**
	 * HTTPS POST
	 * 
	 * @param url
	 * @param paramMap
	 * @param header
	 * @return
	 * @throws Exception
	 */
	public static String postSSL(String url, Map<String, Object> paramMap, Map<String, Object> header) throws Exception {

		return post(url, paramMap, CHARSET, true, header);// 使用默认字符编码，启用SSL
	}
	
	/**
	 * HTTPS POST
	 * 
	 * @param url
	 * @param paramMap
	 * @param timeout
	 * @return
	 * @throws Exception
	 */
	public static String postSSL(String url, Map<String, Object> paramMap, int timeout) throws Exception {

		return post(url, paramMap, CHARSET, true, timeout);// 使用默认字符编码，启用SSL，自定义超时时间
	}
	
	/**
	 * HTTPS POST
	 * 
	 * @param url
	 * @param paramMap
	 * @param charset
	 * @return
	 * @throws Exception
	 */
	public static String postSSL(String url, Map<String, Object> paramMap, String charset) throws Exception {

		return post(url, paramMap, charset, true);// 使用自定义字符编码，启用SSL
	}
	
	/**
	 * HTTP POST
	 * 
	 * @param url
	 * @param paramMap
	 * @param enableSSL
	 * @return
	 * @throws Exception
	 */
	private static String post(String url, Map<String, Object> paramMap, String charset, boolean enableSSL) throws Exception {

		CloseableHttpClient client = (enableSSL) ? createSSLClient() : HttpClients.createDefault();
		CloseableHttpResponse response = null;
		try {

			HttpPost post = new HttpPost(url);
			post.setConfig(REQUEST_CONFIG);
			post.setEntity(new UrlEncodedFormEntity(convertParam(paramMap), charset));
			response = client.execute(post);
			return getResponseResult(response, charset);
		} catch (ConnectionPoolTimeoutException e) {
			throw new ConnectionPoolTimeoutException(createErrorMessage(url, createErrorMessageTimeout(TIMEOUT)));
		} catch (ConnectTimeoutException e) {
			throw new ConnectTimeoutException(createErrorMessage(url, createErrorMessageTimeout(TIMEOUT)));
		} catch (SocketTimeoutException e) {
			throw new SocketTimeoutException(createErrorMessage(url, createErrorMessageTimeout(TIMEOUT)));
		} catch (UnknownHostException e) {
			throw new UnknownHostException(createErrorMessage(url, ERROR_MESSAGE_UNKNOWN_HOST));
		} catch (Exception e) {
			throw e;
		} finally {
			try {
				if (null != response) {
					response.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			client.close();
		}
	}
	
	/**
	 * HTTP POST
	 * 
	 * @param url
	 * @param paramMap
	 * @param enableSSL
	 * @param header
	 * @return
	 * @throws Exception
	 */
	private static String post(String url, Map<String, Object> paramMap, String charset, boolean enableSSL, Map<String, Object> header) throws Exception {
		
		CloseableHttpClient client = (enableSSL) ? createSSLClient() : HttpClients.createDefault();
		CloseableHttpResponse response = null;
		try {
			
			HttpPost post = new HttpPost(url);
			if (null != header) {
				
				for (Entry<String, Object> entry: header.entrySet()) {
					
					post.addHeader(entry.getKey().toString(), entry.getValue().toString());
				}
			}
			post.setConfig(REQUEST_CONFIG);
			post.setEntity(new UrlEncodedFormEntity(convertParam(paramMap), charset));
			response = client.execute(post);
			return getResponseResult(response, charset);
		} catch (ConnectionPoolTimeoutException e) {
			throw new ConnectionPoolTimeoutException(createErrorMessage(url, createErrorMessageTimeout(TIMEOUT)));
		} catch (ConnectTimeoutException e) {
			throw new ConnectTimeoutException(createErrorMessage(url, createErrorMessageTimeout(TIMEOUT)));
		} catch (SocketTimeoutException e) {
			throw new SocketTimeoutException(createErrorMessage(url, createErrorMessageTimeout(TIMEOUT)));
		} catch (UnknownHostException e) {
			throw new UnknownHostException(createErrorMessage(url, ERROR_MESSAGE_UNKNOWN_HOST));
		} catch (Exception e) {
			throw e;
		} finally {
			try {
				if (null != response) {
					response.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			client.close();
		}
	}
	
	/**
	 * HTTP POST
	 * 
	 * @param url
	 * @param paramMap
	 * @param charset
	 * @param enableSSL
	 * @return
	 * @throws Exception
	 */
	private static String post(String url, Map<String, Object> paramMap, String charset, boolean enableSSL, int timeout) throws Exception {

		CloseableHttpClient client = (enableSSL) ? createSSLClient() : HttpClients.createDefault();
		CloseableHttpResponse response = null;
		try {
			
			HttpPost post = new HttpPost(url);
			post.setConfig(createConfig(timeout));
			post.setEntity(new UrlEncodedFormEntity(convertParam(paramMap), charset));
			response = client.execute(post);
			return getResponseResult(response, charset);
		} catch (ConnectionPoolTimeoutException e) {
			throw new ConnectionPoolTimeoutException(createErrorMessage(url, createErrorMessageTimeout(timeout)));
		} catch (ConnectTimeoutException e) {
			throw new ConnectTimeoutException(createErrorMessage(url, createErrorMessageTimeout(timeout)));
		} catch (SocketTimeoutException e) {
			throw new SocketTimeoutException(createErrorMessage(url, createErrorMessageTimeout(timeout)));
		} catch (UnknownHostException e) {
			throw new UnknownHostException(createErrorMessage(url, ERROR_MESSAGE_UNKNOWN_HOST));
		} catch (Exception e) {
			throw e;
		} finally {
			try {
				if (null != response) {
					response.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			client.close();
		}
	}
	/**
	 * http post调用mongodb模块
	 * @param url
	 * @param requestParamer
	 * @return
	 * @throws Exception
	 */
	public static String mongoPost(String url,MongoRequestParamer requestParamer) throws Exception {
		return post(url,defaultGson.toJson(requestParamer));
	}
	/**
	 * HTTP POST(JSON)
	 * 
	 * @param url
	 * @param json
	 * @return
	 * @throws Exception
	 */
	public static String post(String url, String json) throws Exception {

		return post(url, json, CHARSET, false);// 使用默认字符编码，不启用SSL
	}
	
	/**
	 * HTTP POST(JSON)
	 * 
	 * @param url
	 * @param json
	 * @param charset
	 * @return
	 * @throws Exception
	 */
	public static String post(String url, String json, String charset) throws Exception {

		return post(url, json, charset, false);// 使用自定义字符编码，不启用SSL
	}

	/**
	 * HTTPS POST(JSON)
	 * 
	 * @param url
	 * @param json
	 * @return
	 * @throws Exception
	 */
	public static String postSSL(String url, String json) throws Exception {

		return post(url, json, CHARSET, true);// 使用默认字符编码，启用SSL
	}
	
	/**
	 * HTTPS POST(JSON)
	 * 
	 * @param url
	 * @param json
	 * @param timeout
	 * @return
	 * @throws Exception
	 */
	public static String postSSL(String url, String json, int timeout) throws Exception {

		return post(url, json, CHARSET, true, timeout);// 使用默认字符编码，启用SSL，自定义超时时间
	}
	
	/**
	 * HTTPS POST(JSON)
	 * 
	 * @param url
	 * @param json
	 * @return
	 * @throws Exception
	 */
	public static String postSSL(String url, String json, Map<String, Object> header) throws Exception {
		
		return post(url, json, CHARSET, true, header);// 使用默认字符编码，启用SSL
	}

	/**
	 * HTTPS POST(JSON)
	 * 
	 * @param url
	 * @param json
	 * @param charset
	 * @return
	 * @throws Exception
	 */
	public static String postSSL(String url, String json, String charset) throws Exception {

		return post(url, json, charset, true);// 使用自定义字符编码，启用SSL
	}

	/**
	 * HTTP POST(JSON)
	 * 
	 * @param url
	 * @param json
	 * @param charset
	 * @param enableSSL
	 * @return
	 * @throws Exception
	 */
	private static String post(String url, String json, String charset, boolean enableSSL) throws Exception {

		CloseableHttpClient client = (enableSSL) ? createSSLClient() : HttpClients.createDefault();
		CloseableHttpResponse response = null;
		try {

			HttpPost post = new HttpPost(url);
			post.setConfig(REQUEST_CONFIG);
			// [Content-Type: application/json; charset=UTF-8,Content-Length:
			// xx,Chunked: false]
			post.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));
			response = client.execute(post);
			return getResponseResult(response, charset);
		} catch (ConnectionPoolTimeoutException e) {
			throw new ConnectionPoolTimeoutException(createErrorMessage(url, createErrorMessageTimeout(TIMEOUT)));
		} catch (ConnectTimeoutException e) {
			throw new ConnectTimeoutException(createErrorMessage(url, createErrorMessageTimeout(TIMEOUT)));
		} catch (SocketTimeoutException e) {
			throw new SocketTimeoutException(createErrorMessage(url, createErrorMessageTimeout(TIMEOUT)));
		} catch (UnknownHostException e) {
			throw new UnknownHostException(createErrorMessage(url, ERROR_MESSAGE_UNKNOWN_HOST));
		} catch (Exception e) {
			throw e;
		} finally {
			try {
				if (null != response) {
					response.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			client.close();
		}
	}
	
	/**
	 * HTTP POST(JSON)
	 * 
	 * @param url
	 * @param json
	 * @param charset
	 * @param enableSSL
	 * @param timeout
	 * @return
	 * @throws Exception
	 */
	private static String post(String url, String json, String charset, boolean enableSSL, int timeout) throws Exception {

		CloseableHttpClient client = (enableSSL) ? createSSLClient() : HttpClients.createDefault();
		CloseableHttpResponse response = null;
		
		try {

			HttpPost post = new HttpPost(url);
			post.setConfig(createConfig(timeout));
			// ContentType.APPLICATION_JSON: [Content-Type: application/json; charset=UTF-8, Content-Length: xx, Chunked: false]
			post.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));
			response = client.execute(post);
			return getResponseResult(response, charset);
		} catch (ConnectionPoolTimeoutException e) {

			throw new ConnectionPoolTimeoutException(createErrorMessage(url, createErrorMessageTimeout(timeout)));
		} catch (ConnectTimeoutException e) {

			throw new ConnectTimeoutException(createErrorMessage(url, createErrorMessageTimeout(timeout)));
		} catch (SocketTimeoutException e) {

			throw new SocketTimeoutException(createErrorMessage(url, createErrorMessageTimeout(timeout)));
		} catch (UnknownHostException e) {

			throw new UnknownHostException(createErrorMessage(url, ERROR_MESSAGE_UNKNOWN_HOST));
		} catch (Exception e) {
			throw e;
		} finally {
			try {
				if (null != response) {
					response.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			client.close();
		}
	}
	
	/**
	 * HTTP POST(JSON)
	 * 
	 * @param url
	 * @param json
	 * @param charset
	 * @param enableSSL
	 * @param header
	 * @return
	 * @throws Exception
	 */
	private static String post(String url, String json, String charset, boolean enableSSL, Map<String, Object> header) throws Exception {
		
		CloseableHttpClient client = (enableSSL) ? createSSLClient() : HttpClients.createDefault();
		CloseableHttpResponse response = null;
		try {
			
			HttpPost post = new HttpPost(url);
			post.setConfig(REQUEST_CONFIG);
			for (Entry<String, Object> entry: header.entrySet()) {
				
				post.addHeader(entry.getKey().toString(), entry.getValue().toString());
			}
			// ContentType.APPLICATION_JSON: [Content-Type: application/json; charset=UTF-8, Content-Length: xx, Chunked: false]
			post.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));
			response = client.execute(post);
			return getResponseResult(response, charset);
		} catch (ConnectionPoolTimeoutException e) {
			throw new ConnectionPoolTimeoutException(createErrorMessage(url, createErrorMessageTimeout(TIMEOUT)));
		} catch (ConnectTimeoutException e) {
			throw new ConnectTimeoutException(createErrorMessage(url, createErrorMessageTimeout(TIMEOUT)));
		} catch (SocketTimeoutException e) {
			throw new SocketTimeoutException(createErrorMessage(url, createErrorMessageTimeout(TIMEOUT)));
		} catch (UnknownHostException e) {
			throw new UnknownHostException(createErrorMessage(url, ERROR_MESSAGE_UNKNOWN_HOST));
		} catch (Exception e) {
			throw e;
		} finally {
			try {
				if (null != response) {
					response.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			client.close();
		}
	}
	
	/**
	 * 生成URL
	 * 
	 * @param url
	 * @param paramMap
	 * @param charset
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String createURL(String url, Map<String, Object> paramMap, String charset) throws UnsupportedEncodingException {

		StringBuilder sb = new StringBuilder(url);
		sb.append(url.indexOf("?") == -1 ? "?" : "&");
		String value = null;
		for (Map.Entry<String, Object> entry : paramMap.entrySet()) {

			value = URLEncoder.encode(String.valueOf(entry.getValue()), charset);
			sb.append(entry.getKey()).append("=").append(value).append("&");
		}
		sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}
	
	// 创建请求配置信息
	private static RequestConfig createConfig(int timeout) {
		
		RequestConfig config = RequestConfig.custom()
				.setCookieSpec(CookieSpecs.STANDARD_STRICT)
				.setConnectionRequestTimeout(timeout)
				.setConnectTimeout(timeout)
				.setSocketTimeout(timeout)
				.build();
		return config;
	}
	
	// 创建SSLClient
	private static CloseableHttpClient createSSLClient() throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException {
		// 允许信任所有证书
		SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {
			
			public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
				
				return true;
			}
		}).build();
		// 允许信任所有服务器
		SSLConnectionSocketFactory sslSocketFactory = new SSLConnectionSocketFactory(sslContext, NoopHostnameVerifier.INSTANCE);
		return HttpClients.custom().setSSLSocketFactory(sslSocketFactory).build();
	}
	public static Gson defaultGson=new GsonBuilder().create();
	// 转换请求参数
	private static List<NameValuePair> convertParam(Map<String, Object> paramMap) {
		
		List<NameValuePair> paramList = new ArrayList<NameValuePair>();
		Object value = null;
		for (Map.Entry<String, Object> entry : paramMap.entrySet()) {
			
			value = entry.getValue();
			if (value == null) {
				
				continue;
			} else if (ValidatorUtil.isStringArray(value)) {
				
				paramList.add(new BasicNameValuePair(String.valueOf(entry.getKey()), defaultGson.toJson(value)));
			} else {
				
				if (ValidatorUtil.isEmptyIgnoreBlank(String.valueOf(value))) {
					
					continue;
				}
				paramList.add(new BasicNameValuePair(String.valueOf(entry.getKey()), String.valueOf(value)));
			}
		}
		return paramList;
	}
	
	// 创建错误信息
	private static String createErrorMessage(Object param, String errorMessage) {

		return "出错了，" + errorMessage + "，" + param;
	}

	// 创建错误信息:(请求/响应)超时
	private static String createErrorMessageTimeout(int timeout) {
		
		return (timeout / 1000) + "秒未响应，系统超时";
	}
	
	// 创建响应结果信息
	private static String getResponseResult(HttpResponse response, String charset) throws Exception {

		int status = response.getStatusLine().getStatusCode();
		if (status != HttpStatus.SC_OK) {

			throw new ClientProtocolException("响应失败，返回状态码：" + status);
		}
		HttpEntity entity = response.getEntity();
		String result = EntityUtils.toString(entity, charset);
		// 释放资源
		EntityUtils.consume(entity);
		return result;
	}

	private HttpClientUtil() {}
}
