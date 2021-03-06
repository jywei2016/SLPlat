package edu.gzmu.web;

import edu.gzmu.model.CourseMaterial;
import edu.gzmu.provider.ISysProvider;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.http.MediaType;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import top.ibase4j.core.base.provider.BaseController;
import top.ibase4j.core.util.WebUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * <p>
 * 课程教材  前端控制器
 * </p>
 *
 * @author JiaYinWei
 * @since 2018-04-08
 */
@RestController
@RequestMapping("/courseMaterial")
@Api(value = "课程教材接口", description = "课程教材接口")
public class CourseMaterialController extends BaseController<ISysProvider> {
	public String getService() {
		return "courseMaterialService";
	}

	@RequiresPermissions("sys.baseInfo.courseMaterial.read")
	@PutMapping(value = "/read/list")
	@ApiOperation(value = "查询课程教材", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object list(ModelMap modelMap, @RequestBody Map<String, Object> param) {
		return super.queryList(modelMap, param);
	}

	@ApiOperation(value = "查询课程教材", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequiresPermissions("sys.baseInfo.courseMaterial.read")
	@PutMapping(value = "/read/page")
	public Object query(ModelMap modelMap, @RequestBody Map<String, Object> param) {
		return super.query(modelMap, param);
	}

	@RequiresPermissions("sys.baseInfo.courseMaterial.read")
	@PutMapping(value = "/read/detail")
	@ApiOperation(value = "课程教材详情", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object get(HttpServletRequest request) {
		CourseMaterial param = WebUtil.getParameter(request, CourseMaterial.class);
		return super.get(param);
	}

	@PostMapping
	@RequiresPermissions("sys.baseInfo.courseMaterial.update")
	@ApiOperation(value = "修改课程教材", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object update(HttpServletRequest request) {
		CourseMaterial param = WebUtil.getParameter(request, CourseMaterial.class);
		return super.update(param);
	}

	@DeleteMapping
	@RequiresPermissions("sys.baseInfo.courseMaterial.delete")
	@ApiOperation(value = "删除课程教材", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object del(HttpServletRequest request) {
		CourseMaterial param = WebUtil.getParameter(request, CourseMaterial.class);
		return super.del(param);
	}
}