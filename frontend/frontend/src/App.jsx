import { useEffect, useState } from "react";
import { getHello } from "./api/axios"; // sửa đúng đường dẫn

function App() {
    const [message, setMessage] = useState("");

    useEffect(() => {
        getHello()
            .then((res) => {
                setMessage(res.data);
            })
            .catch((err) => {
                console.error(err);
            });
    }, []);

    return <div>
      <h1>Data:</h1>
      <h1>{message}</h1>
    </div>;
}

export default App;