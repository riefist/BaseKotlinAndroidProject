package id.aibangstudio.basekotlin.core.ext

import id.aibangstudio.basekotlin.core.scheduler.SchedulerProvider
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single

fun Completable.with(schedulerProvider: SchedulerProvider) : Completable =
    this.observeOn(schedulerProvider.ui()).subscribeOn(schedulerProvider.io())

fun <T> Flowable<T>.with(schedulerProvider: SchedulerProvider) : Flowable<T> =
    this.observeOn(schedulerProvider.ui()).subscribeOn(schedulerProvider.io())

fun <T> Single<T>.with(schedulerProvider: SchedulerProvider) : Single<T> =
    this.observeOn(schedulerProvider.ui()).subscribeOn(schedulerProvider.io())