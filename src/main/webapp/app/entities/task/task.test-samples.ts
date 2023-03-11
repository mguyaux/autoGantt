import { ITask, NewTask } from './task.model';

export const sampleWithRequiredData: ITask = {
  id: 37978,
  summary: 'CSS Account Up-sized',
};

export const sampleWithPartialData: ITask = {
  id: 30677,
  summary: 'synthesize Research structure',
};

export const sampleWithFullData: ITask = {
  id: 78520,
  summary: 'functionalities',
  priority: 57163,
};

export const sampleWithNewData: NewTask = {
  summary: 'programming virtual auxiliary',
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
