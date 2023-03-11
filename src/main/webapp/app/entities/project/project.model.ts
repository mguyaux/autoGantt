import dayjs from 'dayjs/esm';

export interface IProject {
  id: number;
  name?: string | null;
  fteCount?: number | null;
  startDate?: dayjs.Dayjs | null;
}

export type NewProject = Omit<IProject, 'id'> & { id: null };
