package edu.gzmu.web;

import edu.gzmu.model.School;
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
 * 学校  前端控制器
 * </p>
 *
 * @author JiaYinWei
 * @since 2018-04-08
 */
@RestController
@RequestMapping("/school")
@Api(value = "学校接口", description = "学校接口")
public class SchoolController extends BaseController<ISysProvider> {
    public String getService() {
        return "schoolService";
    }

    @RequiresPermissions("sys.baseInfo.school.read")
    @PutMapping(value = "/read/list")
    @ApiOperation(value = "查询学校", produces = MediaType.APPLICATION_JSON_VALUE)
    public Object list(ModelMap modelMap, @RequestBody Map<String, Object> param) {
        return super.queryList(modelMap, param);
    }

    @ApiOperation(value = "查询学校", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequiresPermissions("sys.baseInfo.school.read")
    @PutMapping(value = "/read/page")
    public Object query(ModelMap modelMap, @RequestBody Map<String, Object> param) {
        return super.query(modelMap, param);
    }

    @RequiresPermissions("sys.baseInfo.school.read")
    @PutMapping(value = "/read/detail")
    @ApiOperation(value = "学校详情", produces = MediaType.APPLICATION_JSON_VALUE)
    public Object get(HttpServletRequest request) {
        School param = WebUtil.getParameter(request, School.class);
        return super.get(param);
    }

    @PostMapping
    @RequiresPermissions("sys.baseInfo.school.update")
    @ApiOperation(value = "修改学校", produces = MediaType.APPLICATION_JSON_VALUE)
    public Object update(HttpServletRequest request) {
        School param = WebUtil.getParameter(request, School.class);
        return super.update(param);
    }

    @DeleteMapping
    @RequiresPermissions("sys.baseInfo.school.delete")
    @ApiOperation(value = "删除学校", produces = MediaType.APPLICATION_JSON_VALUE)
    public Object del(HttpServletRequest request) {
        School param = WebUtil.getParameter(request, School.class);
        return super.del(param);
    }
}