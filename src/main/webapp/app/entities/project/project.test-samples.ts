import dayjs from 'dayjs/esm';

import { IProject, NewProject } from './project.model';

export const sampleWithRequiredData: IProject = {
  id: 55962,
  name: 'COM dedicated Agent',
  fteCount: 65513,
  startDate: dayjs('2023-03-11'),
};

export const sampleWithPartialData: IProject = {
  id: 53955,
  name: 'users parse AGP',
  fteCount: 24714,
  startDate: dayjs('2023-03-11'),
};

export const sampleWithFullData: IProject = {
  id: 50573,
  name: 'Avon Ball',
  fteCount: 92116,
  startDate: dayjs('2023-03-10'),
};

export const sampleWithNewData: NewProject = {
  name: 'Loan Avon',
  fteCount: 89675,
  startDate: dayjs('2023-03-11'),
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
