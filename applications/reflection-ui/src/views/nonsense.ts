import React from "react";

import { element } from "./reactTools";

const nonsense: React.FC<{}> = () => element(
    "div",
    { className: "header" },
    "Nonsense"
);

export { nonsense };
