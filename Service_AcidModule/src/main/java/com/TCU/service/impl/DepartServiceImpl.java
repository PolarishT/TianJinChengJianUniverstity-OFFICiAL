package com.TCU.service.impl;


import com.TCU.Dao.DepartMapper;
import com.TCU.Domain.Depart;
import com.TCU.service.DepartService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class DepartServiceImpl extends ServiceImpl<DepartMapper, Depart> implements DepartService {
}
