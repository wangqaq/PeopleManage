package cn.edu.svtcc.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
@Setter
@Getter
@ToString
public class salaryComposition {
    private long slrycpsid;
    private long epyslryid;
    private BigDecimal basicsley;
    private float overtime;
    private BigDecimal overtimeslry;
    private BigDecimal latetime;
    private BigDecimal insurance;
}
