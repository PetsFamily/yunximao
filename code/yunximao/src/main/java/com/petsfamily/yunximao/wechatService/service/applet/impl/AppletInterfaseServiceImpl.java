package com.petsfamily.yunximao.wechatService.service.applet.impl;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Security;
import java.security.spec.InvalidParameterSpecException;
import java.util.Arrays;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.ClientProtocolException;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.codehaus.xfire.util.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.petsfamily.yunximao.common.util.http.HttpClient;
import com.petsfamily.yunximao.wechatService.common.constant.AppletConstant;
import com.petsfamily.yunximao.wechatService.service.applet.AppletInterfaseService;

@Service
public class AppletInterfaseServiceImpl implements AppletInterfaseService {
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	@Override
	public JSONObject getSessionKey(String code) throws ClientProtocolException, IOException {
		String url = AppletConstant.ROOT
				+"sns/jscode2session"
				+ "?appid="+AppletConstant.APPID 
				+ "&secret="+AppletConstant.APPSECRET 
				+ "&js_code="+code 
				+ "&grant_type=authorization_code";
		String response = HttpClient.get(url);
		return JSONObject.parseObject(response);
	}

	@Override
	public JSONObject getUserInfo(JSONObject dataJson) throws ClientProtocolException, IOException {
		String  code = dataJson.getString("code");
		String  encryptedData = dataJson.getString("encryptedData");
		String  iv =  dataJson.getString("iv");
		if(StringUtils.isBlank(code)||StringUtils.isBlank(encryptedData)||StringUtils.isBlank(iv)) {
			new RuntimeException("参数错误");
		}
		JSONObject sessionKey = this.getSessionKey(code);
		if(!sessionKey.containsKey("session_key")) {
			new RuntimeException("session_key获取失败");
		}
		// 被加密的数据
        byte[] dataByte = Base64.decode(encryptedData);
        // 加密秘钥
        byte[] keyByte = Base64.decode(sessionKey.getString("session_key"));
        // 偏移量
        byte[] ivByte = Base64.decode(iv);
        try {
               // 如果密钥不足16位，那么就补足.  这个if 中的内容很重要
            int base = 16;
            if (keyByte.length % base != 0) {
                int groups = keyByte.length / base + (keyByte.length % base != 0 ? 1 : 0);
                byte[] temp = new byte[groups * base];
                Arrays.fill(temp, (byte) 0);
                System.arraycopy(keyByte, 0, temp, 0, keyByte.length);
                keyByte = temp;
            }
            // 初始化
            Security.addProvider(new BouncyCastleProvider());
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding","BC");
            SecretKeySpec spec = new SecretKeySpec(keyByte, "AES");
            AlgorithmParameters parameters = AlgorithmParameters.getInstance("AES");
            parameters.init(new IvParameterSpec(ivByte));
            cipher.init(Cipher.DECRYPT_MODE, spec, parameters);// 初始化
            byte[] resultByte = cipher.doFinal(dataByte);
            if (null != resultByte && resultByte.length > 0) {
                String result = new String(resultByte, "UTF-8");
                JSONObject resultJson = JSONObject.parseObject(result);
                resultJson.put("sessionKey", sessionKey.getString("session_key"));//一定不要返回给前端
                return resultJson;
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            new RuntimeException("解密错误");
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
            new RuntimeException("解密错误");
        } catch (InvalidParameterSpecException e) {
            e.printStackTrace();
            new RuntimeException("解密错误");
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
            new RuntimeException("解密错误");
        } catch (BadPaddingException e) {
            e.printStackTrace();
            new RuntimeException("解密错误");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            new RuntimeException("解密错误");
        } catch (InvalidKeyException e) {
            e.printStackTrace();
            new RuntimeException("解密错误");
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
            new RuntimeException("解密错误");
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
            new RuntimeException("解密错误");
        }
        return null;
	}

}
