package com.alireza.firstkmmapp.android.di
import android.app.Application
import com.alireza.firstkmmapp.data.local.DatabaseDriverFactory
import com.alireza.firstkmmapp.data.note.SqlDelightNoteDataSource
import com.alireza.firstkmmapp.database.NoteDatabase
import com.alireza.firstkmmapp.domain.note.NoteDataSource
import com.squareup.sqldelight.db.SqlDriver
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideSqlDriver(app: Application): SqlDriver {
        return DatabaseDriverFactory(app).createDriver()
    }

    @Provides
    @Singleton
    fun provideNoteDataSource(driver: SqlDriver): NoteDataSource {
        return SqlDelightNoteDataSource(NoteDatabase(driver))
    }
}