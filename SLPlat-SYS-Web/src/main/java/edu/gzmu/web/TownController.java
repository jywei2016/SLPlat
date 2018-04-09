package edu.gzmu.web;

import edu.gzmu.model.Town;
import edu.gzmu.provider.ISysProvider;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import top.ibase4j.core.base.provider.BaseController;
import top.ibase4j.core.util.WebUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * <p>
 * 镇  前端控制器
 * </p>
 *
 * @author JiaYinWei
 * @since 2018-04-08
 */
@RestController
@RequestMapping("/town")
@Api(value = "镇接口", description = "镇接口")
public class TownController extends BaseController<ISysProvider> {
	public String getService() {
		return "townService";
	}

	@RequiresPermissions("town.read")
	@PutMapping(value = "/read/list")
	@ApiOperation(value = "查询镇", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object query(HttpServletRequest request) {
		Map<String, Object> param = WebUtil.getParameter(request);
		return super.query(param);
	}

	@RequiresPermissions("town.read")
	@PutMapping(value = "/read/detail")
	@ApiOperation(value = "镇详情", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object get(HttpServletRequest request) {
		Town param = WebUtil.getParameter(request, Town.class);
		return super.get(param);
	}

	@PostMapping
	@RequiresPermissions("town.update")
	@ApiOperation(value = "修改镇", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object update(HttpServletRequest request) {
		Town param = WebUtil.getParameter(request, Town.class);
		return super.update(param);
	}

	@DeleteMapping
	@RequiresPermissions("town.delete")
	@ApiOperation(value = "删除镇", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object del(HttpServletRequest request) {
		Town param = WebUtil.getParameter(request, Town.class);
		return super.del(param);
	}
}