package id.aibangstudio.basekotlin.core.usecase

import id.aibangstudio.basekotlin.core.ext.with
import id.aibangstudio.basekotlin.core.scheduler.SchedulerProvider
import io.reactivex.Single

abstract class SingleUseCase<T, in Params>(private val mSchedulers: SchedulerProvider){

    protected abstract fun execute(params: Params? = null) : Single<T>

    operator fun invoke(params: Params? = null) = execute(params).with(mSchedulers)

}