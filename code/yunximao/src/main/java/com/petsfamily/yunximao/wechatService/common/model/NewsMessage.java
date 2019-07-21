package com.petsfamily.yunximao.wechatService.common.model;

public class NewsMessage {
	private String  ToUserName;
	private String  FromUserName;
	private Integer CreateTime;
	private String  MsgType;
	private Integer ArticleCount;
	private String  Articles;
	private Long MsgId;
	public String getToUserName() {
		return ToUserName;
	}
	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}
	public String getFromUserName() {
		return FromUserName;
	}
	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}
	public Integer getCreateTime() {
		return CreateTime;
	}
	public void setCreateTime(Integer createTime) {
		CreateTime = createTime;
	}
	public String getMsgType() {
		return MsgType;
	}
	public void setMsgType(String msgType) {
		MsgType = msgType;
	}
	public String getArticles() {
		return Articles;
	}
	public void setArticles(String articles) {
		Articles = articles;
	}
	public Long getMsgId() {
		return MsgId;
	}
	public void setMsgId(Long msgId) {
		MsgId = msgId;
	}
	public Integer getArticleCount() {
		return ArticleCount;
	}
	public void setArticleCount(Integer articleCount) {
		ArticleCount = articleCount;
	}
	
}
