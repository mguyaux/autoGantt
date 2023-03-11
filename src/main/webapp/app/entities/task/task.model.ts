import { IProject } from 'app/entities/project/project.model';

export interface ITask {
  id: number;
  summary?: string | null;
  priority?: number | null;
  project?: Pick<IProject, 'id'> | null;
  requires?: Pick<ITask, 'id'>[] | null;
  isRequiredBies?: Pick<ITask, 'id'>[] | null;
}

export type NewTask = Omit<ITask, 'id'> & { id: null };
