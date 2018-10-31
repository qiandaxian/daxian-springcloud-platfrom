package com.courier.service.impl;

import com.courier.db.entity.Apiconfig;
import com.courier.service.ApiConfigService;
import com.courier.service.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ApiConfigServiceImpl extends AbstractService<Apiconfig> implements ApiConfigService {
}
