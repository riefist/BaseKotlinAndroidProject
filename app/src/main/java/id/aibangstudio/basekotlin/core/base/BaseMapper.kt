package id.aibangstudio.basekotlin.core.base

interface BaseMapper<M, D> {
    fun mapToDomain(model: M): D
    fun mapToModel(domain: D): M
}