package id.aibangstudio.basekotlin.core.base

import id.aibangstudio.basekotlin.core.Either
import id.aibangstudio.basekotlin.core.exceptions.Failure

abstract class UseCase<out Type, in Params> where Type : Any {
    abstract suspend fun execute(params: Params): Either<Failure, Type>

    class None
}