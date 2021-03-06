package edu.gzmu.service;

import edu.gzmu.model.ProfessionalTitle;
import top.ibase4j.core.base.BaseService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 职称  服务实现类
 * </p>
 *
 * @author JiaYinWei
 * @since 2018-04-08
 */
@Service
@CacheConfig(cacheNames = "ProfessionalTitle")
public class ProfessionalTitleService extends BaseService<ProfessionalTitle> {
    public ProfessionalTitle queryById(Long id){
        ProfessionalTitle professionalTitle = super.queryById(id);
        return professionalTitle;
    }
}