package com.petsfamily.yunximao.wechatService.controller.applet.moment;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.petsfamily.yunximao.common.model.BaseController;
import com.petsfamily.yunximao.common.model.ResponseEntity;
import com.petsfamily.yunximao.momentsService.service.MomentsService;

@RestController
@RequestMapping("/applet")
public class AppletMomentController extends BaseController{
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	@Resource
	private MomentsService momentsService;
	
	@RequestMapping(value = "/moment/queryMomentByPage", method = {RequestMethod.POST })
	public ResponseEntity queryMomentByPage(@RequestBody JSONObject dataJson) throws Exception {
		return momentsService.queryMomentList(dataJson);
	}
	@RequestMapping(value = "/moment/queryCommentsByPage", method = {RequestMethod.POST })
	public ResponseEntity queryCommentsByPage(@RequestBody JSONObject dataJson) throws Exception {
		String id = dataJson.getString("id");
		String token = dataJson.getString("token");
		Integer dataSize = dataJson.getInteger("dataSize");
		dataJson = new JSONObject();
		dataJson.put("token",token);
		dataJson.put("dataSize",dataSize);
		dataJson.put("momentNumber",id);
		return momentsService.queryCommentsList(dataJson);
	}
	@RequestMapping(value = "/moment/queryMomentInfo", method = {RequestMethod.POST })
	public ResponseEntity queryMomentInfo(@RequestBody JSONObject dataJson) throws Exception {
		String id = dataJson.getString("id");
		String token = dataJson.getString("token");
		dataJson = new JSONObject();
		dataJson.put("token",token);
		dataJson.put("momentNumber",id);
		momentsService.readMoment(dataJson);
		return momentsService.queryMomentInfo(dataJson);
	}
	
	@RequestMapping(value = "/moment/queryTotalReadNum", method = {RequestMethod.POST })
	public ResponseEntity queryTotalReadNum(@RequestBody JSONObject dataJson) throws Exception {
		String token = dataJson.getString("token");
		dataJson = new JSONObject();
		dataJson.put("token",token);
		ResponseEntity response = momentsService.queryTotalReadNum(dataJson);
		return response;
	}
	
	@RequestMapping(value = "/moment/queryMomentNum", method = {RequestMethod.POST })
	public ResponseEntity queryMomentNum(@RequestBody JSONObject dataJson) throws Exception {
		String token = dataJson.getString("token");
		dataJson = new JSONObject();
		dataJson.put("token",token);
		ResponseEntity response = momentsService.queryMomentNum(dataJson);
		return response;
	}
	
	@RequestMapping(value = "/moment/like", method = {RequestMethod.POST })
	public ResponseEntity like(@RequestBody JSONObject dataJson) throws Exception {
		String id = dataJson.getString("id");
		String token = dataJson.getString("token");
		dataJson = new JSONObject();
		dataJson.put("token",token);
		dataJson.put("momentNumber",id);
		return momentsService.likeMoment(dataJson);
	}
	
	@RequestMapping(value = "/moment/refuse", method = {RequestMethod.POST })
	public ResponseEntity refuse(@RequestBody JSONObject dataJson) throws Exception {
		String id = dataJson.getString("id");
		String token = dataJson.getString("token");
		dataJson = new JSONObject();
		dataJson.put("token",token);
		dataJson.put("momentNumber",id);
		return momentsService.refuseMoment(dataJson);
	}
	
	@RequestMapping(value = "/moment/submitComments", method = {RequestMethod.POST })
	public ResponseEntity submitComments(@RequestBody JSONObject dataJson) throws Exception {
		String id = dataJson.getString("id");
		String token = dataJson.getString("token");
		String comments = dataJson.getString("comments");
		dataJson = new JSONObject();
		dataJson.put("token",token);
		dataJson.put("momentNumber",id);
		dataJson.put("comments",comments);
		return momentsService.submitComments(dataJson);
	}
	
	@RequestMapping(value = "/moment/deleteComments", method = {RequestMethod.POST })
	public ResponseEntity deleteComments(@RequestBody JSONObject dataJson) throws Exception {
		String id = dataJson.getString("id");
		String token = dataJson.getString("token");
		dataJson = new JSONObject();
		dataJson.put("token",token);
		dataJson.put("commentNumber",id);
		return momentsService.deleteComments(dataJson);
	}
	
	

	@RequestMapping(value = "/moment/queryHotKeyWord", method = {RequestMethod.POST })
	public ResponseEntity queryHotKeyWord(@RequestBody JSONObject dataJson) throws Exception {
		logger.debug(dataJson.toJSONString());
		return momentsService.queryHotKeyWord(dataJson);
	}
	
	
	@RequestMapping(value = "/moment/queryHotSeach", method = {RequestMethod.POST })
	public ResponseEntity queryHotSeach(@RequestBody JSONObject dataJson) throws Exception {
		logger.debug(dataJson.toJSONString());
		return momentsService.queryHotSeach(dataJson);
	}
	
	@RequestMapping(value="/moment/submitPic", method = { RequestMethod.POST})
    public ResponseEntity submitPic(@RequestParam("file") MultipartFile file,
    								@RequestParam("token") String token,
    								@RequestParam("title") String title,
    								@RequestParam("keyWord") String keyWord) {
		JSONObject dataJson = new JSONObject();
		dataJson.put("token", token);
		dataJson.put("file", file);
		dataJson.put("title", title);
		dataJson.put("keyWord", keyWord);
		return momentsService.submitPic(dataJson);
	}
	
	@RequestMapping(value="/moment/submitVideoPic", method = { RequestMethod.POST})
    public ResponseEntity submitVideoPic(@RequestParam("file") MultipartFile file,
	    								 @RequestParam("token") String token,
	    								 @RequestParam("title") String title,
	    								 @RequestParam("keyWord") String keyWord) {
		JSONObject dataJson = new JSONObject();
		dataJson.put("token", token);
		dataJson.put("file", file);
		dataJson.put("title", title);
		dataJson.put("keyWord", keyWord);
		return momentsService.submitVideoPic(dataJson);
	}
	@RequestMapping(value="/moment/submitVideo", method = { RequestMethod.POST})
    public ResponseEntity submitVideo(@RequestParam("file") MultipartFile file,
	    								 @RequestParam("token") String token,
	    								 @RequestParam("title") String title,
	    								 @RequestParam("keyWord") String keyWord,
	    								 @RequestParam("music") String music) {
		JSONObject dataJson = new JSONObject();
		dataJson.put("token", token);
		dataJson.put("file", file);
		dataJson.put("title", title);
		dataJson.put("keyWord", keyWord);
		dataJson.put("music",music);
		return momentsService.submitVideo(dataJson);
	}
	
	@RequestMapping(value="/moment/deleMoment", method = { RequestMethod.POST})
    public ResponseEntity deleMoment(@RequestBody JSONObject dataJson) {
		String id = dataJson.getString("id");
		String token = dataJson.getString("token");
		dataJson = new JSONObject();
		dataJson.put("token",token);
		dataJson.put("momentNumber",id);
		return momentsService.deleMoment(dataJson);
	}
	
	@RequestMapping(value="/moment/updateMoment", method = { RequestMethod.POST})
    public ResponseEntity updateMoment(@RequestBody JSONObject dataJson) {
		String id = dataJson.getString("id");
		String token = dataJson.getString("token");
		String title = dataJson.getString("title");
		String keyWord = dataJson.getString("keyWord");
		dataJson = new JSONObject();
		dataJson.put("token",token);
		dataJson.put("momentNumber",id);
		dataJson.put("title",title);
		dataJson.put("keyWord",keyWord);
		return momentsService.updateMoment(dataJson);
	}
	
	@RequestMapping(value="/moment/initHotKeyWord", method = { RequestMethod.POST})
    public ResponseEntity initHotKeyWord(@RequestBody JSONObject dataJson) {
		return momentsService.initHotKeyWord(dataJson);
	}
	
	@RequestMapping(value="/moment/initHotSeach", method = { RequestMethod.POST})
    public ResponseEntity initHotSeach(@RequestBody JSONObject dataJson) {
		return momentsService.initHotSeach(dataJson);
	}
	
	
	@RequestMapping(value="/moment/videoCallback", method = { RequestMethod.POST})
    public ResponseEntity videoCallback( @RequestParam("checksum") String checksum,
	    								 @RequestParam("content") String content) {
		logger.debug(content);
		JSONObject dataJson = new JSONObject();
		dataJson.put("checksum", checksum);
		dataJson.put("content", content);
		momentsService.callbackAuditVideo(dataJson);
		return ResponseEntity.buildSuccessful();
	}
}
