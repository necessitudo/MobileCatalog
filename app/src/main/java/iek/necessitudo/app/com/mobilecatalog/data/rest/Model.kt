package iek.necessitudo.app.com.mobilecatalog.data.rest

object Model {

    data class GroupDDP(val groupId:String, val desc: Description, val groupEn:String, val file_ref: FileRef, val section:String, val kind:String)

    data class FileRef (val name:String, val md5:String,val uri: String,val size: String )

    data class Description(val ru:String)

}