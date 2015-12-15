package com.ansteel.report.chart.controller;

import com.ansteel.core.constant.Public;
import com.ansteel.core.controller.BaseController;
import com.ansteel.core.controller.SaveBefore;
import com.ansteel.core.domain.BaseEntity;
import com.ansteel.core.domain.EntityInfo;
import com.ansteel.core.service.CheckService;
import com.ansteel.core.utils.FisUtils;
import com.ansteel.report.chart.domain.Chart;
import com.ansteel.report.chart.service.ChartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collection;

/**
 * 创 建 人：gugu
 * 创建日期：2015-05-07
 * 修 改 人：
 * 修改日 期：
 * 描   述：图表控制器。 
 */
@Controller
@RequestMapping(value = "/chart")
public class ChartPageController {
	
	@Autowired
	ChartService chartService;

	@RequestMapping(method = RequestMethod.GET, value = "/show/{name}")
	public String home(@PathVariable("name")String name,
			Model model,HttpServletRequest request) {
		Chart chart=chartService.getChartByName(name);
		model.addAttribute("ReportName", name);
		model.addAttribute("NameData", chartService.getNameData(chart,request));
		model.addAttribute("Chart", chart);
		return FisUtils.page("report:widget/chart/chart.html");
	}
}
