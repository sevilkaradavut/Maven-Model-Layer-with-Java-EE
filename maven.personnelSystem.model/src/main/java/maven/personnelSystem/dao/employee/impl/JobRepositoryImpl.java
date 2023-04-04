package maven.personnelSystem.dao.employee.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import maven.personnelSystem.dao.employee.JobRepository;
import maven.personnelSystem.model.employee.Job;

@Repository
@Transactional
public class JobRepositoryImpl implements JobRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public boolean saveJob(Job job) {
		entityManager.persist(job);
		return true;
	}

	@Override
	public boolean deleteJob(Job job) {
		if (entityManager.contains(job)) {
			entityManager.remove(job);
			return true;
		}
		Job deleteJob = findJobById(job.getJobId());
		entityManager.remove(deleteJob);
		return true;
	}

	@Override
	public Job updateJob(Job job) {
		Job updateJob = entityManager.merge(job);
		entityManager.flush();
		return updateJob;
	}

	@Override
	public Job findJobById(Long jobId) {
		TypedQuery<Job> typedQuery = entityManager.createNamedQuery("Job.findEmployeesById", Job.class);
		typedQuery.setParameter("jobId", jobId);
		return typedQuery.getSingleResult();
	}

	@Override
	public List<Job> findAllJobs() {
		TypedQuery<Job> typedQuery = entityManager.createNamedQuery("Job.findAll", Job.class);
		return typedQuery.getResultList();
	}

}
