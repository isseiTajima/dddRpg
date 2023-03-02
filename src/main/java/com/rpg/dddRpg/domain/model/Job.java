package com.rpg.dddRpg.domain.model;

import com.rpg.dddRpg.domain.value.Name;

import java.util.UUID;

/**
 * 職業
 */
public class Job {

    private final UUID jobId;
    private final Name jobName;

    Job(UUID jobId, Name jobName) {
        this.jobId = jobId;
        this.jobName = jobName;
    }

    /**
     * 初期ジョブの生成
     *
     * @return 初期ジョブ
     */
    public static Job initial() {
        return new Job(null , null);
    }

    public UUID getJobId() {
        return jobId;
    }

    public Name getJobName() {
        return jobName;
    }
}
