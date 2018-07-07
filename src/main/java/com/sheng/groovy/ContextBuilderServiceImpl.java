//package com.sheng.groovy;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.TypeReference;
//import com.souche.finance.price.core.dao.CalcDao;
//import com.souche.finance.price.core.dao.CalcPlanDao;
//import com.souche.finance.price.core.model.CalcContext;
//import com.souche.finance.price.core.model.domain.CalcDO;
//import com.souche.finance.price.core.model.domain.CalcPlanDO;
//import com.souche.finance.price.core.service.CalcParamFillerService;
//import com.souche.finance.price.core.service.CalcRuleParserService;
//import com.souche.finance.price.core.service.ContextBuilderService;
//import com.souche.optimus.common.util.CollectionUtils;
//import groovy.lang.GroovyShell;
//import groovy.lang.Script;
//import lombok.Data;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import javax.annotation.PostConstruct;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
///**
// * 计算参数赋值-计算优化把规则引擎先编译好
// * <p>
// * Created by zhengzs on 2017/6/11.
// */
//@Slf4j
//@Service
//@Data
//public class ContextBuilderServiceImpl implements ContextBuilderService {
//
//    @Autowired
//    private CalcParamFillerService calcParamFillerService;
//
//    @Autowired
//    private CalcRuleParserService calcRuleParserService;
//
//    @Autowired
//    private CalcPlanDao calcPlanDao;
//
//    @Autowired
//    private CalcDao calcDao;
//
//    private static Map<Long, Map<String, Script>> initScriptMap = new HashMap<Long, Map<String, Script>>();
//
//    @Override
//    public CalcContext getCalcContext(String paramVo) {
//        log.info("paramVo : " + paramVo);
//        CalcContext calcContext = new CalcContext();
//        Map<String, Object> map = JSON.parseObject(paramVo, new TypeReference<Map<String, Object>>() {
//        });
//        Long calcPlanId = Long.valueOf(map.get("calcPlanId").toString());
//        map.remove("calcPlanId");
//        CalcPlanDO calcPlanDO = calcPlanDao.findById(calcPlanId);
//        Map<String, Object> calcParam = calcParamFillerService.getCalRuleByParamVo(calcPlanId);
//
//        calcContext.setCalcParam(calcParam);
//        Map<String, Script> scriptMap = this.initScriptMap.get(calcPlanDO.getCalcId());
//        if (CollectionUtils.isNotEmpty(map)) {
//            Map<String, Script> mp = new HashMap<>();
//            for (Map.Entry<String, Object> entry : map.entrySet()) {
//                mp.put(entry.getKey(), scriptMap.get(entry.getKey()));
//            }
//            calcContext.setCalcScript(mp);
//        } else {
//            calcContext.setCalcScript(scriptMap);
//        }
//        return calcContext;
//    }
//
//    @PostConstruct
//    public void initScriptMap() {
//        List<CalcDO> allCalcId = calcDao.findList();
//        for (CalcDO calcDO : allCalcId) {
//            long calcId = calcDO.getCalcId();
//            Map<String, String> calcScript = calcRuleParserService.getCalRule(calcId, null);
//            Map<String, Script> initMap = new HashMap<String, Script>();
//            for (Map.Entry<String, String> entry : calcScript.entrySet()) {
//                Script shell = new GroovyShell().parse(entry.getValue().toString());
//                initMap.put(entry.getKey(), shell);
//            }
//            this.initScriptMap.put(calcId, initMap);
//        }
//    }
//}
