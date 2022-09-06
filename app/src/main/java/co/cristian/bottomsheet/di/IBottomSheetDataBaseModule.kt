package co.cristian.bottomsheet.di

import co.cristian.bottomsheet.data.interfaces.IBottomSheetDataBase
import co.cristian.bottomsheet.data.local.realm.BottomSheetDataBase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface IBottomSheetDataBaseModule {
    @Binds
    fun bind(repository: BottomSheetDataBase): IBottomSheetDataBase
}