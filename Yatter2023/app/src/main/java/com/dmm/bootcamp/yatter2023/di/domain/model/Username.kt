package com.dmm.bootcamp.yatter2023.di.domain.model

import com.dmm.bootcamp.yatter2023.common.ddd.Identifier

class Username(value: String) : Identifier<String>(value) {
  fun validate(): Boolean = value.isNotBlank()
}
