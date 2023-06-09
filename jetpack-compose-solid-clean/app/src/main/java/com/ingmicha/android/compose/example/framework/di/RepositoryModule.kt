package com.ingmicha.android.compose.example.framework.di

import android.content.Context
import com.ingmicha.android.compose.core.repository.NoteRepository
import com.ingmicha.android.compose.example.framework.RoomNoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    fun provideRepository(@ApplicationContext context: Context) =
        NoteRepository(RoomNoteDataSource(context))
}