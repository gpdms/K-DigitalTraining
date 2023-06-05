package com.study.springboot.entity

import lombok.AllArgsConstructor
import lombok.Getter
import lombok.NoArgsConstructor
import lombok.Setter
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class Dept(@Id val deptno: String, val dname: String, val loc: String) {
    override fun toString(): String {
        return "Dept(deptno= '$deptno', dname='$dname', loc=$loc)"
    }
}