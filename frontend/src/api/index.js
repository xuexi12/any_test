const request = async (url, options) => {
  const response = await fetch(url, options)
  const result = await response.json()
  // console.log("|result", url, JSON.stringify(result));
  return result
}

const origin = "/api"
const post = (path, data) => {
  const url = `${origin}${path}`
  console.log("|url", url)
  const options = {
    method: "POST",
    headers: new Headers({
      "Content-Type": "application/json",
    }),
    body: JSON.stringify(data),
  }
  return request(url, options)
}

const get = (path, data) => {
  const search = data ? "?" + new URLSearchParams(data).toString() : ""
  const url = `${origin}${path}${search}`
  const options = {
    method: "GET",
  }
  return request(url, options)
}

export { post as postApi, get as getApi }
