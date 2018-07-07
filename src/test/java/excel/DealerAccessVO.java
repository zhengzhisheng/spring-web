package excel;

import lombok.Data;

import java.util.Date;

/**
 * 车商信息
 *
 * @author zzs .
 * @since 2018/4/11
 */
@Data
public class DealerAccessVO {

    private Long dealerId; //车商记录ID
    private String dealerNo; //车商编号
    private String dealerName; //车商名称
    private String shopCode; //车商店铺Code
    private String legalPersonName; //法人名称
    private String legalPersonMobile; //法人联系方式
    private String legalPersonIdcardNo; //法人身份证号码
    private String provinceCode; //省编码
    private String provinceName; //省名称
    private String cityCode; //城市code
    private String cityName; //城市名称
    private String districtCode; //地区code
    private String districtName; //地区名字
    private String area; //地区
    private String dealerAddress; //车商地址
    private String dealerAlipayAccount; //企业支付宝账号
    private String dealerBankAccountNo; //车商对公账号
    private String dealerBankName; //开户银行
    private Boolean ycpAuth; //易诚拍认证
    private String ycpLevel; //易诚拍星级
    private String contactPersonName; //联系人姓名
    private String contactPersonMobile; //联系人电话c
    private String mbApplicationCode; //网商申请编号
    private String mbCreditCode; //网商授信编号
    private Integer auditStatus; //审核状态
    private String auditStatusStr; //审核状态
    private Long positionAmount; //网商授信额度
    private Long lessPositionAmount; //剩余授信额度
    private Boolean registerPass; //是否通过网商授信申请
    private String remark; //备注
    private String description; //驳回原因
    private String creditCode; //信用代码
    private String identityCardCorrect; //身份证正面
    private String identityCardOpposite; //身份证反面
    private String businessLicPic; //营业执照
    private String phone;
    private String fileList; //经营数据
    private String fileList1; //场地租赁合同
    private String fileList2; //展厅或仓库照片
    private String fileList3; //手持身份证照片
    private String fileList4; //组织机构代码证
    private String fileList5; //税务登记证
    private Date firstAuditDate; //初审通过时间
    private Date recheckDate; //复审通过时间
    private Date thirdAuditDate; //三审通过时间
    private Date passDate; //准入时间
    private Integer loanOrder; //借款订单(待还款和已逾期)
    private Long totalLoan; //借款总额
    private Integer noOverDue; //在途未逾期笔数
    private Long totalNoOverDue; //在途未逾期总额
    private Integer overDue; //在途逾期笔数
    private Long totalOverDue; //在途逾期总额
}
