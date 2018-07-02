package iek.necessitudo.app.com.mobilecatalog.domain.model

import iek.necessitudo.app.com.mobilecatalog.data.model.Description
import iek.necessitudo.app.com.mobilecatalog.data.model.FileRef

data class GroupDDP(val groupId:String, val desc: Description, val groupEn:String, val file_ref: FileRef, val section:String, val kind:String)