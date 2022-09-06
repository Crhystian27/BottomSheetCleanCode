package co.cristian.bottomsheet.di

import co.cristian.bottomsheet.data.repository.BottomSheetRepository
import co.cristian.bottomsheet.domain.interfaces.IBottomSheetRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface IBottomSheetRepositoryModule {
    @Binds
    fun bind(repository: BottomSheetRepository): IBottomSheetRepository
}