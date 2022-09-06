package co.cristian.bottomsheet.base

abstract class BaseUseCase<T>  {
    abstract suspend fun execute(): List<T>
}