package com.imooc.wiremock;
import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.configureFor;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.removeAllMappings;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlPathEqualTo;

import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.core.io.ClassPathResource;

/**
 * 开发前虚拟的接口  wiremock
 *
 * 去 wiremock 官网下载jar 并在本地运行起来  java -jar wiremock-standalone-2.17.0.jar --port 8062
 *  这里端口是自定义的 ，这里定为8062
 *
 */
public class MockServer {


	private static void mock(String url, String file) throws IOException {
		ClassPathResource resource = new ClassPathResource("mock/response/" + file + ".txt");
		String content = StringUtils.join(FileUtils.readLines(resource.getFile(), "UTF-8").toArray(), "\n");

		// 伪造测试桩
		stubFor(get(urlPathEqualTo(url)).willReturn(aResponse().withBody(content).withStatus(200)));
	}

	/**
	 * 测试的主函数
	 *
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		configureFor(8062);
		removeAllMappings(); // 清除之前的配置

		mock("/order/1", "01");
		mock("/order/2", "02");
	}

}
