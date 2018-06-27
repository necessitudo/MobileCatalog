package iek.necessitudo.app.com.mobilecatalog.domain.model

import iek.necessitudo.app.com.mobilecatalog.data.Description
import iek.necessitudo.app.com.mobilecatalog.data.FileRef

data class GroupDDP(val groupId:String, val desc: Description, val groupEn:String, val file_ref: FileRef, val section:String, val kind:String)