package com.TCU2.service.impl;


import com.TCU2.Dao.DepartMapper;
import com.TCU2.Domain.Depart;
import com.TCU2.service.DepartService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class DepartServiceImpl extends ServiceImpl<DepartMapper, Depart> implements DepartService {
}
