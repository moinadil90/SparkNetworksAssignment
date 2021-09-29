package com.moin.sparknetworks.model.repository

import android.content.Context
import com.moin.sparknetworks.annotations.Generated
import com.moin.sparknetworks.di.DaggerQuestionComponent
import com.moin.sparknetworks.di.QuestionModule
import com.moin.sparknetworks.model.storage.PersonalityStorageContract
import com.moin.sparknetworks.model.storage.records.QuestionRecord
import com.moin.sparknetworks.presentation.view.PersonalityActivity
import io.reactivex.Completable
import io.reactivex.Single
import org.json.JSONObject
import javax.inject.Inject

class PersonalityRepository: PersonalityRepositoryContract {

    @Inject
    lateinit var personalityStorage: PersonalityStorageContract

    @Generated
    constructor(context: Context, activity: PersonalityActivity) {
        DaggerQuestionComponent.builder()
            .questionModule(QuestionModule(context, activity))
            .build().inject(this)
    }

    constructor(personalityStorage: PersonalityStorageContract) {
        this.personalityStorage = personalityStorage
    }


    override fun save(personalityObject: JSONObject): Completable = personalityStorage.save(personalityObject)

    override fun fetchQuestionsFromDB(): Single<List<QuestionRecord>> {
       return personalityStorage.fetchQuestionsFromDB()
    }
}