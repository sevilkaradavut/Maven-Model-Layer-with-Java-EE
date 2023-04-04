package maven.personnelSystem.service.employee;

import java.util.List;

import maven.personnelSystem.model.employee.Job;

public interface JobService {

	boolean saveJob(Job job);

	boolean deleteJob(Job job);

	Job updateJob(Job job);

	Job findJobById(Long jobId);

	List<Job> findAllJobs();
}
