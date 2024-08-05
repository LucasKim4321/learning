
console.log("reply.js start");
console.log('bno2',bno);

async function getReply(bno) {
    console.log("==> getReply bno: ",bno);

    const response = await axios.get(`/replies/list/${bno}`);
    console.log("==> getReply response: ",response); // 서버로부터 응답받은 객체
    console.log();
    return response.data;
}

// 1. 게시글에 대한 댓글 List, 인자값이 여러개 전달 받을 경우 => {데이터1, 데이터2, ...}
async function getList(bno, page, size, goLast) {
    console.log("==> getList bno: ",bno);

    const result = await axios.get(`/replies/list/${bno}`, { params: {page, size} });
    console.log("==> getList result: ",result); // 서버로부터 응답받은 객체

    if (goLast) {
        // 댓글 총 개수
        const total = result.data.total;
        // 댓글 마지막 페이지 계산 = 댓글 총 개수 / 페이지 사이즈 => 자리올림
        const lastPage = parseInt(Math.ceil(total/size));
        return getList(bno, lastPage, size);
    }
    return result.data;
}


