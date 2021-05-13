FROM gitpod/workspace-full-vnc

USER gitpod

RUN sudo apt-get -q update && \
    sudo apt-get install -yq chromium-browser && \
    sudo rm -rf /var/lib/apt/lists/*
    
RUN apt-get update \
&& apt-get install -y \
   unzip \
   wget \
   libnss3 \
&& rm -rf /var/lib/apt/lists/* \
&& echo "progress = dot:giga" | tee /etc/wgetrc \
&& mkdir -p /mnt /opt /data \
&& wget https://github.com/andmarios/duphard/releases/download/v1.0/duphard -O /bin/duphard \
&& chmod +x /bin/duphard
