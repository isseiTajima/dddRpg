package com.rpg.dddRpg.domain.model;

import com.rpg.dddRpg.domain.type.JobClassification;

/**
 * 職業
 */
public class Job {

    private final JobClassification jobClassification;

    Job(JobClassification jobClassification) {
        this.jobClassification = jobClassification;
    }

    /**
     * 初期ジョブの生成
     *
     * @return 初期ジョブ
     */
    public static Job initial() {
        return new Job(JobClassification.noJob);
    }

    public JobClassification getJobClassification() {
        return jobClassification;
    }
}
