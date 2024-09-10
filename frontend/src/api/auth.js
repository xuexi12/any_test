import { getRequest } from ".";

export const login = (username, password) => {
  return getRequest("/user/doLogin", { username, password });
};
