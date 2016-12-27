package com.cardinfolink.showmoney.constans;

/**
 * Created by jie on 16/4/19.
 * <p/>
 * 常用的常量
 */
public class Constants {
    /**
     *  DragGridView每个Item的key
     */
    public static final String CELL_KEY = "item_text";
    /**
     *  主页保存的条目的顺序
     */
    public static final String SAVE_DATA = "main pager item";
    /**
     *  消费结果
     */
    public static final String CONSUME_RESULT = "consume result";
    /**
     *  消费结果状态，成功或者失败
     */
    public static final String CONSUME_STATUS = "consume_status";
    /**
     *  消费金额
     */
    public static final String CONSUME_AMOUNT = "consume_amount";

    /**
     * 统计的标志
     */
    public static final String IS_STATISTICS_FRAGMENT = "is_statistics_fragment";
    public static final String UPDATE_NETWORK_STATISTICS_INFO = "com.cardinfolink.smart.pos.update_statistics_info";//更新统计消息

    /**
     * 判断刷卡操作来自于哪个页面
     */
    public static final String SWIPED_FROM_ACTIVITY = "swiped_from_activity"; //保存activity来源的key
    public static final String FROM_CONSUME_ACTIVITY = "from_consume_activity"; // 来自于消费页面
    public static final String FROM_QR_ACTIVITY = "from_qr_activity"; // 来自于扫码页面
    public static final String FROM_DCC2EDC_ACTIVITY = "from_dcc2edc_activity"; // 来自于dcc转edc页面
    public static final String FROM_QR_CANCEL_ACTIVITY = "from_qr_cancel_activity"; // 来自于扫码撤销页面
    public static final String FROM_BACKOUT_ACTIVITY = "from_backout_activity"; // 来自于撤销页面
    public static final String FROM_REFUND_ACTIVITY = "from_refund_activity"; // 来自于退货页面
    public static final String FROM_BALANCE_ACTIVITY = "from_balance_activity"; // 来自于余额查询页面
    public static final String FROM_PRE_AUTH_ACTIVITY = "from_pre_auth_activity"; // 来自于预授权页面
    public static final String FROM_PRE_AUTH_CANCEL_ACTIVITY = "from_pre_auth_cancel_activity"; // 来自于预授权撤销页面
    public static final String FROM_PRE_AUTH_COMPLETE_ACTIVITY = "from_pre_auth_complete_activity"; // 来自于预授权完成页面
    public static final String FROM_PRE_AUTH_COMPLETE_CANCEL_ACTIVITY = "from_pre_auth_complete_cancel_activity"; // 来自于预授权完成取消页面
    public static final String FROM_BANK_REFUND_ACTIVITY = "from_bank_refund_activity"; // 来自于银行卡退货页面
    public static final String FROM_QR_REFUND_ACTIVITY = "from_qr_refund_activity"; // 来自于扫码退货页面
    public static final String FROM_TIP_TAKE_ACTIVITY = "from_tip_take_activity"; // 来自于收取小费页面
    public static final String FROM_TIP_REVOKE_ACTIVITY = "from_tip_revoke_activity"; // 来自于小费撤销页面


    /**
     * 支付相关
     */
    public static final String THE_KEY_OF_PAYMENT_TYPE = "the_key_of_payment_type";//支付类型
    public static final String BANK_CARD_PAYMENT = "bank_card_payment";//银行卡支付
    public static final String MOVEMENT_TERMINAL_PAYMENT = "movement_terminal_payment";//移动支付


    /**
     * 系统设置相关
     */
    public static final String THE_MODE_OF_MANAGEMENT = "the_mode_of_management";//管理模式
    public static final String THE_SWITCH_OF_CHECK = "the_switch_of_check";//复核开关
    public static final String THE_SWITCH_OF_LOCK_SCREEN = "the_switch_of_lock_screen";//管理模式
    public static final String THE_SWITCH_OF_ELECTRIC_SIGN_IN = "the_switch_of_electric_sign_in";//电子签名
    public static final String HAS_CHECKER_PASSWORD = "has_checker_password";//是否需要审核员密码


    /**
     * 预授权相关
     */
    public static final String CARD_INFO = "card_info";//刷卡返回银行卡信息

    /**
     * 订单
     */
    public static final String ORDER_ITEM = "ORDER_ITEM";
    public static final String UPDATE_ORDER_RECEIVER = "update_order_receiver";//更新广播
    public static final String ACTIVITY_NEED_CLOSED_ACTION = "activity_need_closed_action";//通知activity关闭
    public static final String MAIN_CONSUME_CLEAR_INPUT_ACTION = "main_consume_clEAR_INPUT_ACTION";//通知主页清空输入
    /**
     * 激活
     */
    public static final String HAD_ACTIVAED = "had activated";//是否已激活
    public static final String HAD_DOWNLOAD_SYSTEM_PARAMS = "had_download_system_params";//是否已下载参数

    //    public static final String DEVICE_TOKEN = "umeng_device_token";//友盟deviceToken
    public static final String SYSTEM_PARAMS = "system_params";
    public static final String PAYMENT_TYPE = "payment_type";//支付是否为银行卡支付


    public static final String AMOUNT = "Amount";
    public static final String ORIGINALTRADEDATE = "OriginalTradeDate";
    public static final String AUTHCODE = "AuthCode";

    public static final String VOUCHERNUMBER = "VOUCHERNUMBER";
    public static final String SWIPED_DISPLAY_DATA = "swiped_display_data";
    public static final String LIQUIDATION_DISPLAY_DATA = "liquidation_display_data";

    public static final String FROM_SALERETURN_ACTIVITY = "FROM_SALERETURN_ACTIVITY";
    public static final String CANCEL_ORDER_SUCCESS = "cancel_order_success";//取消订单结果
    public static final String reference = "reference";
    public static final String tradeDate = "tradeDate";
    public static final String tradeAmount = "tradeAmount";

    public static final String EXCEPTION_REQUEST = "exception_request";//出现异常的请求
    public static final String CARD_BRAND = "card_brand";//消费方式

    public static final String CHECK_TITLE = "check_activity_title";//需要核对密码的类
    public static final String ANIM_ACTIVITY_INDEX = "anim_activity_index";//目标activity
    public static final String CHECK_TYPE = "check_type";//检查密码的种类

    public static final String AMOUNT_IS_NONE = "0.001";
    public static final String APP_VERSON_CODE = "app_verson_code";

    public static final String SERIAL_NUMBER = "sn";
    public static final String UPDATE_MAIN_ITEMS_ACTION = "update_main_items_action";//更新主页面items的action
    public static final String IS_DCC2EDC = "is_dcc2edc";//是否是DCC转EDC的交易

    public static final String ELECTRIC_SIGN_IN_FILE_PATH = "electric_sign_in_file_path";//电子签名文件路径
    public static final String ELECTRIC_SIGN_IN_JPG_FILE_PATH = "electric_jpg_sign_in_file_path";

    /**
     * 小费相关
     */
    public static final String TIP_TRANS = "TIP_TRANS";

    /**
     * 记账相关
     */
    public static final String CURRENT_CHARGE_UP_BATCH_NUM = "CHARGE_UP_BATCH_NUM";//记账批次号
    public static final String CHARGE_UP_RESULT = "CHARGE_UP_RESULT";//记账结果
    public static final String SETTLE_FLAG = "CHARGE_UP_STATUS_FLAG";//记账账单结算标志
    public static final String CHARGE_UP_RESULT_ID = "CHARGE_UP_RESULT_ID";
    public static final String FROM_SETTLED_SUCCESS = "FROM_SETTLED_SUCCESS";

    /**
     * 账单动画相关
     */
    public static final String ANIM_TYPE = "ANIM_TYPE";
    public static final int ANIM_TYPE_ALPHA = 0x1;
    public static final int ANIM_TYPE_SCALE = 0x2;
    public static final int ANIM_TYPE_SLIDE_BOTTOM = 0x3;
    public static final int ANIM_TYPE_SLIDE_LEFT = 0x4;
    public static final int ANIM_TYPE_SLIDE_RIGTH = 0x5;


    public static final String MSG_ENCRYPT_FLAG = "MSG_ENCRYPT_FLAG";//全报文加密标志位
    public static final String TRANS_SETTLE_BATCH_NUM = "TRANS_SETTLE_BATCH_NUM";//结算批次号;
    public static final String TRANS_SETTLE_DATETIME = "TRANS_SETTLE_DATETIME";//结算时间;

    /**
     * 佰馏卡相关
     */
    public static final String VC_CURRENT_SELECTION = "VC_CURRENT_SELECTION";
    //    public static final String VC_BALANCE = "VC_BALANCE";//佰馏卡余额
    public static final String VC_NUMBER = "VALUE_CARD_NUMBER";//佰馏卡卡号
    public static final String VC_TRANS_NUM = "VALUE_TRANS_NUMBER";//佰馏卡交易号
    public static final int VC_SELECTION_CONSUME = 0x111;//消费
    public static final int VC_SELECTION_RECHARGE = 0x112;//充值
    public static final int VC_SELECTION_REFUND = 0x113;//退货
    public static final int VC_SELECTION_CANCEL = 0x114;//取消
    public static final int VC_SELECTION_RECHARGE_CANCEL = 0x115;//消费取消
    public static final int VC_SELECTION_CONSUME_CANCEL = 0x116;//充值取消

    //    public static final String VC_POINT = "VALUE_CARD_POINT";//佰馏卡积分
    public static final String MOBILE_OPTIONS = "MOBILE_OPTIONS";//移动运营商
    public static final String TRANS_NUM = "trans_no";//移动运营商
    public static final String IS_TOTAL_INFO = "IS_TOTAL_INFO";//保存合计信息打印
    public static final String IS_TRANS_INFO = "IS_TRANS_INFO";//保存合计信息打印
    public static final String HEADER_AND_FOOTER = "HEADER_AND_FOOTER";//保存页眉页脚

    public static final int IS_CLUB_CARD = 0x200;//会员卡
    public static final int IS_VC_VALUE_CARD = 0x201;//Value Card
    public static final int IS_VC_TOTAL = 0x202;//合计
    public static final int IS_VC_MAINTAIN = 0x203;//维修
    public static final int IS_VC_PRINT_AGAIN = 0x204;//再次打印
    public static final int IS_VC_AMOUNT = 0x205;//Value Card-金额
    public static final int IS_VC_OFFERS = 0x206;//Value Card-优惠
    public static final int IS_VC_POINTS = 0x207;//Value Card-积分
    public static final int IS_VC_PRINT_BALANCE = 0x208;//Value Card-余额打印
    public static final int IS_VC_CONSUME = 0x209;//Value Card-金额-消费
    public static final int IS_VC_RECHARGE = 0x210;//Value Card-金额-充值
    public static final int IS_VC_REFUND = 0x211;//Value Card-金额-退货
    public static final int IS_VC_CANCEL = 0x212;//Value Card-金额-取消
    public static final int IS_VC_CONSUME_CANCEL = 0x213;//Value Card-金额-取消-消费取消
    public static final int IS_VC_RECHARGE_CANCEL = 0x214;//Value Card-金额-取消-充值取消
    public static final int IS_VC_CASH_GIVE = 0x215;//Value Card-优惠-付现赠送
    public static final int IS_VC_OFFERS_GIVE = 0x216;//Value Card-优惠-优惠赠送
    public static final int IS_VC_OFFERS_CANCEL = 0x217;//Value Card-优惠-取消
    public static final int IS_VC_CASH_GIVE_WITH_POINTS = 0x218;//积分-付现赠送
    public static final int IS_VC_POINTS_GIVE = 0x219;//积分-积分赠送
    public static final int IS_VC_POINTS_CONSUME = 0x220;//积分-积分消费
    public static final int IS_VC_POINTS_CANCEL = 0x221;//积分-取消
    public static final int IS_VC_CANCEL_POINT = 0x222;//积分-取消-取消积分
    public static final int IS_VC_POINTS_CONSUME_CANCEL = 0x223;//积分-取消-消费取消
    public static final int IS_VC_MAINTAIN_SETTINGS = 0x224;//维修-设置
    public static final int IS_VC_MAINTAIN_PRACTICE = 0x225;//维修-练习模式
    public static final int IS_VC_MAINTAIN_MANAGER = 0x226;//维修-管理设定
    public static final int IS_VC_MAINTAIN_SETTINGS_SETTINGS = 0x227;//维修-设置-设定
    public static final int IS_VC_MAINTAIN_MANAGER_SETTINGS = 0x228;//维修-管理设定-设置
    public static final int IS_VC_MAINTAIN_MANAGER_REGISTER = 0x229;//维修-管理设定-注册
    public static final int IS_VC_MAINTAIN_HEADER_AND_FOOTER = 0x230;//维修-管理设定-页眉脚
    public static final int IS_VC_RECEIPT = 0x231;//再次打印-收据条
    public static final int IS_VC_PRINT_AGAIN_TOTAL = 0x232;//再次打印-合计
    public static final int IS_VC_HANDLE = 0x234;//刷卡或者扫码
    public static final String VC_PING_RESULT = "VC_PING_RESULT";//ping的结果
    public static final String VC_OPERATOR = "VC_OPERATOR";//移动通信公司
    public static final String VC_BALANCE_INQUIRY = "VC_BALANCE_INQUIRY";//保存查询的余额Response
    public static final String VC_ERROR_MSG = "VC_ERROR_MSG";//错误信息
    public static final String VC_EXTRA = "VC_EXTRA";//打印需要数据
    public static final String VC_PING_SUCCESS = "VC_PING_SUCCESS";//存储ping的结果


    /**
     * 佰馏卡测试数据
     */
    public static String VC_IP;
    public static int VC_PORT;
    public static int VC_TIME_OUT;
    public static String VC_MERID = "5087";
    public static String VC_SHOP_ID;
    public static String VC_TERMINAL_ID;
    public static final String VC_SLIP_NO = "000000000000000";

    public static final String VC_SHOP_ID_KEY = "VC_SHOP_ID";
    public static final String VC_TERMINAL_ID_KEY = "VC_TERMINAL_ID";
    public static final String VC_SLIP_NO_KEY = "VC_SLIP_NO";
    public static final String VC_PORT_KEY = "VC_PORT_KEY";
    public static final String VC_IP_KEY = "VC_IP";
    public static final String VC_IS_LOAD = "VC_IS_LOAD";
    public static String VC_TIME_OUT_KEY = "VC_TIME_OUT";

}
