package com.petsfamily.yunximao.common.util;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.dom4j.DocumentHelper;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * xml工具类
 * 
 * @author miklchen
 *
 */
public class XmlUtil {
	
	private static final Logger logger = LoggerFactory.getLogger(XmlUtil.class);

	/**
	 * 解析request流对象InputStream 解析xml,返回第一级元素键值对。如果第一级元素有子节点，则此节点的值是子节点的xml数据。
	 * 
	 * @param strxml
	 * @return
	 * @throws JDOMException
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, String> doXMLParse(InputStream in) throws JDOMException, IOException {
		Map<String, String> m = new HashMap<String, String>();
		SAXBuilder builder = new SAXBuilder();
		Document doc = builder.build(in);
		Element root = doc.getRootElement();
		List<Object> list = root.getChildren();
		Iterator<Object> it = list.iterator();
		while (it.hasNext()) {
			Element e = (Element) it.next();
			String k = e.getName();
			String v = "";
			List<Object> children = e.getChildren();
			if (children.isEmpty()) {
				v = e.getTextNormalize();
			} else {
				v = XmlUtil.getChildrenText(children);
			}
			m.put(k, v);
		}
		// 关闭流
		in.close();
		return m;
	}

	/**
	 * 解析String类型的xml流对象InputStream
	 * 解析xml,返回第一级元素键值对。如果第一级元素有子节点，则此节点的值是子节点的xml数据。
	 * 
	 * @param strxml
	 * @return
	 * @throws JDOMException
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, String> doXMLParse(String strxml) throws JDOMException, IOException {
		if (null == strxml || "".equals(strxml)) {
			return null;
		}

		Map<String, String> m = new HashMap<String, String>();
		InputStream in = new ByteArrayInputStream(strxml.getBytes("UTF-8"));
		SAXBuilder builder = new SAXBuilder();
		Document doc = builder.build(in);
		Element root = doc.getRootElement();
		List<Object> list = root.getChildren();
		Iterator<Object> it = list.iterator();
		while (it.hasNext()) {
			Element e = (Element) it.next();
			String k = e.getName();
			String v = "";
			List<Object> children = e.getChildren();
			if (children.isEmpty()) {
				v = e.getTextNormalize();
			} else {
				v = XmlUtil.getChildrenText(children);
			}
			m.put(k, v);
		}

		// 关闭流
		in.close();

		return m;
	}

	/**
	 * 获取子结点的xml
	 * 
	 * @param children
	 * @return String
	 */
	@SuppressWarnings("unchecked")
	private static String getChildrenText(List<Object> children) {
		StringBuffer sb = new StringBuffer();
		if (!children.isEmpty()) {
			Iterator<Object> it = children.iterator();
			while (it.hasNext()) {
				Element e = (Element) it.next();
				String name = e.getName();
				String value = e.getTextNormalize();
				List<Object> list = e.getChildren();
				sb.append("<" + name + ">");
				if (!list.isEmpty()) {
					sb.append(XmlUtil.getChildrenText(list));
				}
				sb.append(value);
				sb.append("</" + name + ">");
			}
		}

		return sb.toString();
	}
	

	//输出格式化的XML
	public static String prettyPrint(final String xml) {
		if (StringUtils.isBlank(xml)) {
			logger.error("xml was null or blank in prettyPrint()");
			return xml;
		}
		final StringWriter sw;
		try {
			final OutputFormat format = OutputFormat.createPrettyPrint();
			final org.dom4j.Document document = DocumentHelper.parseText(xml);
			sw = new StringWriter();
			final XMLWriter writer = new XMLWriter(sw, format);
			writer.write(document);
		} catch (Exception e) {
			logger.error("Error pretty printing xml:\n" + xml, e);
			return xml;
		}
		return sw.toString();
	}
	
	public static String toXml(Object object) throws IllegalArgumentException, IllegalAccessException {
		StringBuffer buffer = new StringBuffer();
        buffer.append("<xml>");
        if (object != null) {
        	Field[] fields = object.getClass().getDeclaredFields();
        	for (Field field: fields) {
        		field.setAccessible(true);
                buffer.append("<" + field.getName() + ">");
                if(String.valueOf(field.get(object)).startsWith("<item>")&&String.valueOf(field.get(object)).endsWith("</item>")){
                	buffer.append(field.get(object));
                }else {
                	buffer.append("<![CDATA[" + field.get(object) + "]]>");
                }     
                buffer.append("</" + field.getName() + ">");
            }
        }
        buffer.append("</xml>");
        return buffer.toString();
	}
	
	

}
