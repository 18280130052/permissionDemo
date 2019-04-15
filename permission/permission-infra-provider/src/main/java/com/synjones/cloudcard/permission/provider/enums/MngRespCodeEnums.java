package com.synjones.cloudcard.permission.provider.enums;


public enum MngRespCodeEnums {

	SUCCESS( "0000", "处理成功" ),
	UNKNOWN_ERROR( "1001", "未知错误" ),
	ILLEGAL_PARAMETERS( "1002", "非法参数" ),
	NOT_ALLOWED_OPERATION( "1003", "不允许操作" ),
	SYSTEM_ERROR( "1004", "系统错误" ),
	SYSTEM_ERROR_DB( "1005", "系统错误" ),
	REPEATED_DATA( "1006", "重复数据" ),
	NO_DATA( "1007", "无数据" ),
	ILLEGAL_OPERATION( "1008", "非法操作" ),
	RPC_ERROR( "1009", "服务调用异常" ),
	CARD_NOT_REGISTER( "1010", "卡片未注册" ),
	CARD_IN_USE( "1011", "卡片已被使用" ),
	ACCT_NOT_FOUND( "1014", "账户不存在"),
	PRD_NOT_FOUND( "1015", "产品不存在"),
	PRD_NOT_MATCH( "1016", "产品代码不匹配"),
	SUBJECT_NOT_FOUND("1017", "科目不存在"),
	ACCT_TYPE_NOT_FOUND("1018", "账户类型不存在"),
	MCH_NOT_FOUND( "1019", "商户账户不存在"),
	SYSTEM_NOT_PREPARE( "1020", "系统未启动" ),
	CUST_MEMBER_NOT_FOUND( "1021", "身份信息不存在" ),
	BANK_REL_NOT_FOUND( "1022", "银行卡对应关系不存在" ),
	AUTOTRANS_ALREADY_EXISTS( "1023", "自动转账关系已经存在" ),
	CARD_ID_NOT_MATCH( "1024", "卡号不一致" ),
	SYSTEM_CONFIG_ERROR( "1025", "系统配置错误" ),
	CUST_NOT_MATCH( "1026", "此交易只能在开户行操作" ),
	SYSTEM_CAP_DAY( "1027", "系统正在日切" ),
	TRADE_PWD_NOT_MATCH( "1028", "密码错误" ),
	MCH_SETTLE_TRANAMT_IS_ZERO( "1029", "清算余额为0" ),
	ACCT_SUB_EXISTS( "1030", "存在子账户" ),
	ACCT_TYPE_SPECIAL_FUND("1031","专款专用类型账户，不允许消费"),
	TRAN_CODE_NOT_FOUND("1032","交易代码不存在"),
	MQ_ERROR( "1033", "mq投递失败" ),
	MQ_TRANACTION_FAIL( "1034", "本地事务执行失败" ),
	DELETE_FAILED_SUB_DATA( "1035", "删除数据失败，存在子数据" ),
	CARD_CUST_DIFF( "1036", "卡片所属客户与账户不同" ),



	ACCT_STATUS_ERROR( "1101", "账户状态错误"),
	ACCT_FREEZE( "1102", "账户已冻结"),
	ACCT_UNFREEZE( "1103", "账户已解冻"),
	ACCT_SLEEP( "1104", "账户已休眠"),
	ACCT_ACTIVE( "1105", "账户已激活"),
	ACCT_CARD_SUBSIDY_SEQ_ERROR("1106", "补助戳错误" ),
	ACCT_BAL_NOT_ENOUGH( "1107", "账户余额不足"),
	BIZ_NOT_FOUND( "1108", "原流水不存在" ),
	BIZ_DIFFER( "1109", "流水信息不符" ),
	BIZ_CANCELLED( "1110", "此交易已经撤销" ),
	BIZ_NOT_ALLOW_CANCEL( "1111", "此种交易不允许撤销" ),
	CARD_LOST( "1112", "卡片已挂失" ),
	CARD_UNLOST( "1113", "卡片已解挂" ),
	ACCT_CHECK_STATUS( "1114", "账户对账不平"),
	TRAN_AMT_TOO_lARGE( "1115", "交易金额太大"),
	ACCT_CARD_NO_SUBSIDY_SEQ("1116", "无过渡余额可领取" ),
	ACCT_NO_CHECK_STATUS( "1117", "账户对账不平标识未设置"),
	BIZ_REFUND_AMT_NOT_ENOUGH( "1118", "原流水退款金额不足"),
	TRCD_NOT_ALLOW_REFUND( "1119", "此种交易不允许退款" ),
	TRCD_NOT_FOUND( "1120", "无此交易" ),
	CAP_DATE_NOT_ALLOW_CANCEL( "1121", "已日切，不允许撤销" ),
	ACCT_NOT_ALLOW_SAME( "1122", "账户不允许相同"),
	ACCT_EXPIRE( "1123", "账户已经过期"),
	ACCT_BAL_NOT_ZERO( "1124", "余额不为0,，不能销户"),
	TRAN_AMT_DIFF( "1125", "交易金额不符"),
	SUB_TYPE_ERROR( "1126", "子交易类型错误"),
	WHITE_LIST_SEQNO_ERROR( "1127", "名单同步序号错误"),
	AUTOCODE_INVALID( "1128", "付款码无效");



	private	String	respCode;
	private	String	respInfo;


	private MngRespCodeEnums(String respCode, String respInfo ){
		this.setRespCode(respCode);
		this.setRespInfo(respInfo);
		
	}

	public String getRespCode() {
		return respCode;
	}


	public void setRespCode(String respCode) {
		this.respCode = respCode;
	}


	public String getRespInfo() {
		return respInfo;
	}


	public void setRespInfo(String respInfo) {
		this.respInfo = respInfo;
	}
	
	

}
