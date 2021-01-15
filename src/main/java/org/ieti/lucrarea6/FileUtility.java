package org.ieti.lucrarea6;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.*;

public class FileUtility {

	public static void writeToFile(SubscriptionPlan plan) {
		XmlMapper mapper = new XmlMapper();

		try {
			mapper.writeValue(new File("src/main/resources/plan.xml"), plan);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static SubscriptionPlan readFromFile() {
		File file = new File("src/main/resources/plan.xml");
		XmlMapper mapper = new XmlMapper();

		try {
			String xml = inputStreamToString(new FileInputStream(file));
			SubscriptionPlan subscriptionPlan = mapper.readValue(xml, SubscriptionPlan.class);
			return subscriptionPlan;
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static String inputStreamToString(InputStream is) throws IOException {
		StringBuilder sb = new StringBuilder();
		String line;
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		while ((line = br.readLine()) != null) {
			sb.append(line);
		}
		br.close();
		return sb.toString();
	}

}
