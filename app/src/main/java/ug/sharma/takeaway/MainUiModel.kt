package ug.sharma.takeaway

import ug.sharma.takeaway.model.ResponseDTO


sealed class MainUiModel {

    data class OnSucess(var responseDTO: ResponseDTO):MainUiModel()

    data class Onerror(var error:String):MainUiModel()
}