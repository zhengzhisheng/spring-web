//package excel;
//
///**
// * @author zzs .
// * @since 2018/5/24
// */
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONArray;
//import com.alibaba.fastjson.JSONObject;
//import com.sheng.commons.utils.DateTimeUtils;
//import com.sheng.commons.utils.ExcelUtils;
//import com.sheng.commons.utils.ExportResponseUtil;
//import com.sheng.commons.utils.FileUtils;
//import com.sheng.commons.utils.ImageUtils;
//import org.springframework.util.ResourceUtils;
//
//import javax.servlet.http.HttpServletResponse;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.text.DecimalFormat;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Date;
//import java.util.List;
//public class ExcelTest {
//
//
//    //导出
//    public void exportDealerFirst(HttpServletResponse response, String dealerAccessQueryParam1) {
////        List<FclDealerInfoDTO> fclDealerInfoDTOS = fclDealerApiService.findList(dealerAccessQueryParam1);
//        List<DealerAccessVO> dealerAccessVOS = new ArrayList<>();
////        for (FclDealerInfoDTO fclDealerInfoDTO : fclDealerInfoDTOS) {
////            DealerAccessVO dealerAccessVO = ModelConvertMapper.INSTANCE.mapDealerAccessVO(fclDealerInfoDTO);
////            dealerAccessVOS.add(dealerAccessVO);
////        }
//        File excelFile = this.createExcelFile(dealerAccessVOS);
//
//        ExportResponseUtil.doExportResponse(response, excelFile);
//    }
//
//    private File createExcelFile(List<DealerAccessVO> dealerAccessVOS) {
//        String sheetName = "待初审车商";
//        String fileName = "待初审车商.xls";
//        List<String> titleRow = Arrays.asList("车商编号", "车商名称", "联系人姓名", "联系方式", "地址", "企业支付宝账户", "申请时间", "驳回原因", "备注");
//
//        List<List<String>> dataRows = new ArrayList<>();
//        DecimalFormat df = new DecimalFormat("0.00");
//        for (DealerAccessVO dealerAccessVO : dealerAccessVOS) {
//            List<String> row = new ArrayList<>();
//            row.add(dealerAccessVO.getDealerNo());
//            row.add(dealerAccessVO.getDealerName());
//            row.add(dealerAccessVO.getContactPersonName());
//            row.add(dealerAccessVO.getContactPersonMobile());
//            row.add(dealerAccessVO.getDealerAddress());
//            row.add(dealerAccessVO.getDealerAlipayAccount());
//            row.add(dealerAccessVO.getDescription());
//            row.add(dealerAccessVO.getRemark());
//            dataRows.add(row);
//        }
//        File file = ExcelUtils.createExcel(fileName, sheetName, titleRow, dataRows);
//        return file;
//    }
//
//    //导入
////    public Map<String, Object> uploadThirdAuditDealer(Context context, HttpServletResponse response) {
////        List<String> failInfo = Lists.newArrayList();
////        ResultObject<FileInfo> result = new ResultObject<>();
////        Map<String, Object> resultMap = Maps.newHashMap();
////        FileInfo file = context.getAttachment("file");
////        if (file == null || file.getFileType() == null) {
////            throw new ServiceException("文件不能为空");
////        }
////        if (!"xls".equals(file.getFileType().toLowerCase()) && !"xlsx".equals(file.getFileType().toLowerCase())) {
////            throw new ServiceException("不是Excel文件");
////        }
////        List<DealerAccessVO> dealerAccessVOS = Lists.newArrayList();
////        try {
////            URL url = new URL(file.getFullFilePath());
////            HttpURLConnection urlCon = (HttpURLConnection) url.openConnection();
////            urlCon.setConnectTimeout(5000);
////            urlCon.setReadTimeout(5000);
////            XSSFWorkbook xssfWorkbook = new XSSFWorkbook(urlCon.getInputStream());
////            XSSFSheet sheet = xssfWorkbook.getSheetAt(0);
////            int rowCount = sheet.getLastRowNum() + 1;
////            if (rowCount > 101) { //控制上传条数
////                throw new ServiceException("限制上传内容100条");
////            }
////            for (Row row : sheet) {
////                if (row.getRowNum() == rowCount) {
////                    continue;
////                }
////                if (row.getRowNum() == 0) {
////                    if (row.getPhysicalNumberOfCells() < 15) {
////                        throw new ServiceException("Excel文件表头不正确");
////                    }
////                    continue;
////                }
////                Map<String, Object> map = Maps.newHashMap();
////                FclDealerInfoDTO fclDealerInfoDTO = null;
////                if (row.getCell(0) != null && ExcelUtil.checkCell(row.getCell(0), String.class) != null) {
////                    fclDealerInfoDTO = fclDealerApiService.findByDealerNo(ExcelUtil.checkCell(row.getCell(0), String.class));
////                    if (null == fclDealerInfoDTO) {
////                        throw new ServiceException("第" + row.getRowNum() + "行车商编号有误");
////                    }
////                } else {
////                    throw new ServiceException("第" + row.getRowNum() + "缺少车商编号");
////                }
////                if (row.getCell(14) != null && ExcelUtil.checkCell(row.getCell(14), String.class) != null) {
////                    fclDealerInfoDTO.setAuditStatus(ExcelUtil.checkCell(row.getCell(14), String.class).equals("是") ? DealerStatusEnum.WAIT_MARGIN.getCode() : DealerStatusEnum.THIRD_REFUSE.getCode());
////                    fclDealerInfoDTO.setDescription("");
////                    if (ExcelUtil.checkCell(row.getCell(14), String.class).equals("是")) {
////                        fclDealerInfoDTO.setThirdAuditDate(new Date());
////                        fclDealerInfoDTO.setDescription(DealerRecordEnum.THIRD_PASS.getMsg());
////                    } else {
////                        fclDealerInfoDTO.setDescription(DealerRecordEnum.THIRD_REJECT.getMsg());
////                    }
////                } else {
////                    throw new ServiceException("第" + row.getRowNum() + "没有填写审核状态");
////                }
////                fclDealerInfoDTO.setThirdAuditDate(new Date());
////                DealerAccessVO dealerAccessVO = ModelConvertMapper.INSTANCE.mapDealerAccessVO(fclDealerInfoDTO);
////                dealerAccessVOS.add(dealerAccessVO);
////            }
////            if (dealerAccessVOS.size() <= 0) {
////                throw new ServiceException("导入文件为空");
////            }
////            //导入数据
////            for (DealerAccessVO dealerAccessVO : dealerAccessVOS) {
////                FclDealerInfoDTO fclDealerInfoDTO = ModelConvertMapper.INSTANCE.mapFclDealerInfoDTO(dealerAccessVO);
////                fclDealerApiService.handleOkDealerInfo(fclDealerInfoDTO.getDealerId(),fclDealerInfoDTO.getDescription(),fclDealerInfoDTO.getAuditStatus());
////            }
////            result.setCode(200);
////            result.setMsg("上传成功");
////            result.setItem(file);
////            resultMap.put("result", result);
////            resultMap.put("failInfo", failInfo);
////            return resultMap;
////        } catch (ParseException | IOException e) {
////            e.printStackTrace();
////        }
////        result.setCode(400);
////        result.setMsg("上传失败");
////        result.setItem(file);
////        resultMap.put("result", result);
////        resultMap.put("failInfo", failInfo);
////        return resultMap;
////    }
//
//    //导出模板
//    public void exportDealerRecheckTemp(HttpServletResponse response) {
//        try {
//            String fileName = "待三审车商资料.xlsx";
//            File file = ResourceUtils.getFile("classpath:/tem/dealerThirdAuditTemp.xlsx");
//            ExportResponseUtil.doExportResponse(response, file, fileName);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//    }
//
//    //创建图片文件包
//    private File createImgFile(List<DealerAccessVO> dealerAccessVOS) throws IOException {
//        //创建图片文件包
//        File parentFile = new File(DateTimeUtils.formatDate(new Date(), "yyyy-MM-dd") + "待三审车商图片");
//        parentFile.mkdirs();
//        for (DealerAccessVO dealerAccessVO : dealerAccessVOS) {
//            //创建每个经销商的图片文件包
//            String name = dealerAccessVO.getDealerNo();
//            File picFile = new File(parentFile, name);
//            picFile.mkdirs();
//            //图片从阿里云下载
//            ImageUtils.createImg(picFile, dealerAccessVO.getIdentityCardCorrect(), "身份证正面", "souche");
//            ImageUtils.createImg(picFile, dealerAccessVO.getIdentityCardOpposite(), "身份证反面", "souche");
//            ImageUtils.createImg(picFile, dealerAccessVO.getBusinessLicPic(), "营业执照或市场合同", "souche");
//
//            JSONArray jsonArray = JSON.parseArray(dealerAccessVO.getFileList2());
//            for (Object url : jsonArray) {
//                JSONObject jsonObject = (JSONObject) url;
//                ImageUtils.createImg(picFile, jsonObject.get("url").toString(), "展厅或仓库照片", "souche");
//            }
//
//            JSONArray list1 = JSON.parseArray(dealerAccessVO.getFileList());
//            for (Object url : list1) {
//                JSONObject jsonObject = (JSONObject) url;
//                String imgTitle = "经营数据" + jsonObject.get("url").toString().substring(jsonObject.get("url").toString().lastIndexOf("."), jsonObject.get("url").toString().length());
//                File file = new File(picFile, imgTitle);
////                writePrivateUrl(jsonObject.get("url").toString(),file.getPath());
//                ImageUtils.download(file, jsonObject.get("url").toString());
//            }
//
//            JSONArray list2 = JSON.parseArray(dealerAccessVO.getFileList1());
//            for (Object url : list2) {
//                JSONObject jsonObject = (JSONObject) url;
//                String imgTitle = "场地租赁合同" + jsonObject.get("url").toString().substring(jsonObject.get("url").toString().lastIndexOf("."), jsonObject.get("url").toString().length());
//                File file = new File(picFile, imgTitle);
////                writePrivateUrl(jsonObject.get("url").toString(),file.getPath());
//                ImageUtils.download(file, jsonObject.get("url").toString());
//            }
//        }
//
//        return parentFile;
//    }
//
//    public void exportDealerAccessInfo(HttpServletResponse response, String dealerAccessQueryParam) {
////        List<FclDealerInfoDTO> fclDealerInfoDTOS = fclDealerApiService.findList(dealerAccessQueryParam);
//        List<DealerAccessVO> dealerAccessVOS = new ArrayList<>();
////        for (FclDealerInfoDTO fclDealerInfoDTO : fclDealerInfoDTOS) {
////            DealerAccessVO dealerAccessVO = ModelConvertMapper.INSTANCE.mapDealerAccessVO(fclDealerInfoDTO);
////            dealerAccessVOS.add(dealerAccessVO);
////        }
//
//        //分别创建ExcelFile文件和图片包
//        File excelFile = this.createExcelFile(dealerAccessVOS);
//        File imgFile = null;
//        try {
//            imgFile = this.createImgFile(dealerAccessVOS);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        File[] files = new File[2];
//        files[0] = excelFile;
//        files[1] = imgFile;
//        FileUtils.downloadZipFile(files, DateTimeUtils.formatDate(new Date(), "yyyy-MM-dd") + "待三审车商详情.zip", response);
//
//        //删除服务器上的包
//        FileUtils.deleteDirectory(imgFile.getAbsolutePath()); //TODO
//    }
//}
