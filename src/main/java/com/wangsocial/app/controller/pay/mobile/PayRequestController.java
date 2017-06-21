package com.wangsocial.app.controller.pay.mobile;

import com.wangsocial.app.common.exception.BusinessException;
import com.wangsocial.app.common.exception.SystemException;
import com.wangsocial.app.common.model.json.AjaxResult;
import com.wangsocial.app.controller.base.BaseController;
import com.wangsocial.app.dto.PayRequestParam;
import com.wangsocial.app.service.IPayRouteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 支付请求相关接口
 * Created by Martin on 2016/7/01.
 */
@Api(tags = "支付模块")
@Controller
@RequestMapping("/app/payRequest")
public class PayRequestController extends BaseController {

    private static Logger logger = LoggerFactory.getLogger(PayRequestController.class);
    @Autowired
    private IPayRouteService payRouteService;

    /**
     * 组装支付请求报文
     * @param payRequestParam
     * @return
     * @throws BusinessException
     * @throws SystemException
     */
    @ApiOperation(value = "下单", notes = "")
    @ResponseBody
    @RequestMapping(value = "/getPayParams", method = RequestMethod.POST)
    public AjaxResult getPayParams(@RequestBody PayRequestParam payRequestParam) throws BusinessException, SystemException {
        return AjaxResult.getOK(payRouteService.getPayRetMap(payRequestParam));
    }

}
